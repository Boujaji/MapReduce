# hadoop-examples-mapreduce
$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \wordcount \gutenberg/20417.txt.utf-8  word
20/11/12 13:33:22 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
...
20/11/12 13:33:54 INFO mapreduce.Job: Job job_1603290159664_4512 completed successfully
20/11/12 13:33:54 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=267013
                FILE: Number of bytes written=1027211
               ...
               HDFS: Number of write operations=2
        Job Counters
                Launched map tasks=1
                Launched reduce tasks=1
                Other local map tasks=1
                Total time spent by all maps in occupied slots (ms)=21261
                Total time spent by all reduces in occupied slots (ms)=28020
                Total time spent by all map tasks (ms)=7087
                Total time spent by all reduce tasks (ms)=7005
                Total vcore-milliseconds taken by all map tasks=7087
                Total vcore-milliseconds taken by all reduce tasks=7005
                Total megabyte-milliseconds taken by all map tasks=10885632
                Total megabyte-milliseconds taken by all reduce tasks=14346240
        Map-Reduce Framework
                Map input records=12760
              ...
           Peak Reduce Physical memory (bytes)=313638912
                Peak Reduce Virtual memory (bytes)=3879165952
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters
                Bytes Read=674570
        File Output Format Counters
                Bytes Written=196183

# $ hdfs dfs -cat \word/part-r-00000
straight        11
straight-haired 2
straightforward.        1
strain, 1
strains 2
strange 16
strangely       2
strangers       1
strata  6
strata; 1
straw   3
straws  2
straws, 1
straws. 3
stray   2

#1.8.1 $ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \district trees.csv tree
11
12
13
14
15
16
17
18
19
20
3
4
5
6
7
8
9
ARRONDISSEMENT
#$1.8.2 $ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \specie  trees.csv speci


#1.8.3 $ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \trees_count  trees.csv count

#1.8.4 $ $ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \max_specie  trees.csv max
