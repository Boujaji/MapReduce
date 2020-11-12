package com.opstty.mapper;




import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class Max_Mapper extends Mapper<Object, Text,Text, DoubleWritable> {
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (!value.toString().contains("HAUTEUR")) {
            if (!value.toString().split(";")[6].equals("")) {
                Text specie = new Text(value.toString().split(";")[3]);
                Double taille = new Double(value.toString().split(";")[6]);


                context.write(specie, new DoubleWritable(taille));

            }
        }
    }
}

