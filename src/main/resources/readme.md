

To confirm whether stalls are in postgrest or sqs,  I created a program to analyze the sqs log and have these preliminary results:

* We already made our 1 second goal.

* At 2019-05-23 11:40:54 we had a 41 second hang between the sqsDeleteFinish and the dequeFinish.(line 53168 sqs3.log)

* A small percentage of cycles stall from 2 and 6 seconds during POST postgrest. The stall is between dequeFinish and postgrestFinish.

Log gap analysis where one cycle is dequeFinish to nextDequeFinish.  I measured 3 gaps: dequeFinish to postgrestFinish, postgrestFinish to sqsDeleteFinish, and sqsDeleteFinish to nextDequeFinish.

Regarding SQSListener design goals:
- the process should report happy path performance and anomalous gaps
- detect SQL deque hang.   From my analysis a possible reaction is log the dequed sqs message and then terminate.
- if a task's time exceeds a threshold, report it.
- rare, but PostGREST could fail.  In that case we would loose the dequed sqs element. See my post on http-request-timeout.