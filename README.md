# Nextflow Plugin template

A Nextflow's plugin template in Java

## Build

`./gradlew build`

## Install

`./gradlew unzipPlugin`

This task will build and install the plugin into your $HOME/.nextflow/plugins directory

## Test

`nextflow run example.nf -plugins nf-plugin-javatemplate@0.0.1`

```shell
N E X T F L O W  ~  version 23.10.0
Launching `example.nf` [pedantic_wescoff] DSL2 - revision: 7846a5069f
AOXRNWYMWG
```

## Debug

- Create a remote debug in your IDE (tested with Intellij)
- set a breakpoint, for example in ExampleFucntions line 31
- execute `nextflow -remote-debug run example.nf -plugins nf-plugin-javatemplate@0.0.1`
- attach the debug to the process

a few seconds later the breakpoint will be reached and the pipeline will be paused

