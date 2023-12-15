package com.nextflow.plugin;

import nextflow.plugin.BasePlugin;
import org.pf4j.PluginWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExamplePlugin extends BasePlugin{
    private final static Logger logger = LoggerFactory.getLogger(ExamplePlugin.class);

    public ExamplePlugin(PluginWrapper wrapper) {
        super(wrapper);
        initPlugin();
    }

    private void initPlugin(){
        logger.info("{} plugin initialized", this.getClass().getName());
    }
}
