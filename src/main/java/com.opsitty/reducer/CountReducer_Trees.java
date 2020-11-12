package com.opstty.reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class CountReducer_Trees extends Reducer<Text, IntWritable, Text, IntWritable> {
    private IntWritable resultat = new IntWritable();

    public void reduce(Text trees_countKey, Iterable<IntWritable> values, Context contex)
            throws IOException, InterruptedException {
        int somme = 0;
        for (IntWritable valeur : values) {
            somme += valeur.get();
        }
        resultat.set(somme);
        contex.write(trees_countKey, resultat);
    }
}
