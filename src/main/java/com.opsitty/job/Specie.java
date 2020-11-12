
package com.opstty.job;
        import com.opstty.mapper.Specie_Mapper;
        import com.opstty.reducer.Specie_Reducer;
        import org.apache.hadoop.conf.Configuration;
        import org.apache.hadoop.fs.Path;
        import org.apache.hadoop.io.NullWritable;
        import org.apache.hadoop.io.Text;
        import org.apache.hadoop.mapreduce.Job;
        import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
        import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
        import org.apache.hadoop.util.GenericOptionsParser;



public class Specie {
    public static void main(String [] args) throws Exception{
        Configuration conf=new Configuration() ;
        String[] otherArgs=new GenericOptionsParser(conf,args).getRemainingArgs();
        if(otherArgs.length<2){
            System.err.println("Usage: district <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job=Job.getInstance(conf, "specie");
        job.setJarByClass(Specie.class);
        job.setMapperClass(Specie_Mapper.class);
        job.setCombinerClass(Specie_Reducer.class);
        job.setReducerClass(Specie_Reducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        for(int i=0;i< otherArgs.length-1;i++){
            FileInputFormat.addInputPath(job,new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,new Path(otherArgs[otherArgs.length-1]));
        System.exit(job.waitForCompletion(true) ? 0:1);
    }
}
