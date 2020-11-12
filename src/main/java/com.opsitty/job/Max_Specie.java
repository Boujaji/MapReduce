package com.opstty.job;

import com.opstty.mapper.Max_Mapper;
import com.opstty.reducer.Max_Reducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;



public class Max_Specie{
    public static void main(String [] args) throws Exception{
        Configuration config=new Configuration() ;
        String[] otherArgs=new GenericOptionsParser(config,args).getRemainingArgs();
        if(otherArgs.length<2){
            System.err.println("erreur");
            System.exit(2);
        }
        Job job=Job.getInstance(config, "max_specie");
        job.setJarByClass(Max_Specie.class);
        job.setMapperClass(Max_Mapper.class);
        job.setCombinerClass(Max_Reducer.class);
        job.setReducerClass(Max_Reducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);
        for(int i=0;i< otherArgs.length - 1;i++){
            FileInputFormat.addInputPath(job,new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,new Path(otherArgs[otherArgs.length -1]));
        System.exit(job.waitForCompletion(true) ? 0:1);
    }
}
