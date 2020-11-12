package com.opstty.reducer;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Specie_Reducer extends Reducer<Text,NullWritable,Text, NullWritable> {
    public void reduce(Text specieKey,Iterable<NullWritable> values,Context cont) throws IOException,InterruptedException{
        cont.write(specieKey,NullWritable.get());
    }


}
