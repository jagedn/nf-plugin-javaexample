package com.nextflow.plugin;

import nextflow.plugin.extension.Function;
import nextflow.plugin.extension.PluginExtensionPoint;
import nextflow.Session;

import java.util.Random;

public class ExampleFunctions extends PluginExtensionPoint{

    private Session session;
    Random random = new Random();

    @Override
    protected void init(Session session) {
        this.session = session;
    }


    /*
     *  Nextflow Function example
     * Generate a random string
     *
     * Using @Function annotation we allow this function can be imported from the pipeline script
     */
    @Function
    public String randomString(){
        return randomString(9);
    }

    @Function
    public String randomString(int targetStringLength){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
