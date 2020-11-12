package com.opstty.reducer;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Max_Reducer extends Reducer<Text,DoubleWritable,Text, DoubleWritable> {
    private DoubleWritable resultat=new DoubleWritable();
    public void reduce(Text Key,Iterable<DoubleWritable> values,Context context) throws IOException,InterruptedException{
       double maximum=0;
       for(DoubleWritable valeur :values){
           if(valeur.get() > maximum)maximum=valeur.get();
       }
       resultat.set(maximum);
        context.write(Key,resultat);
    }


}
