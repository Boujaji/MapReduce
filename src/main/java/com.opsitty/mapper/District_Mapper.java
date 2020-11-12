package com.opstty.mapper;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


import java.io.IOException;
import java.util.StringTokenizer;

public class District_Mapper extends Mapper<LongWritable, Text,Text,NullWritable> {
    public void map(LongWritable key,Text value, Context context) throws IOException,InterruptedException{
        if(!value.toString().contains("ARRONDISSEMENTS")){
            Text district_mapper =new Text(value.toString().split(";")[1]);


            context.write(district_mapper, NullWritable.get());

        }
    }
}

