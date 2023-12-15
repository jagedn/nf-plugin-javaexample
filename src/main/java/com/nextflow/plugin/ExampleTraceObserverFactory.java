package com.nextflow.plugin;

import nextflow.Session;
import nextflow.processor.TaskHandler;
import nextflow.processor.TaskProcessor;
import nextflow.trace.TraceObserver;
import nextflow.trace.TraceObserverFactory;
import nextflow.trace.TraceRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

public class ExampleTraceObserverFactory implements TraceObserverFactory{
    private final static Logger logger = LoggerFactory.getLogger(ExampleTraceObserverFactory.class);
    @Override
    public Collection<TraceObserver> create(Session session) {
        TraceObserver observer = new TraceObserverImpl();
        return List.of(observer);
    }

    static class TraceObserverImpl implements TraceObserver{
        @Override
        public void onFlowCreate(Session session) {
            logger.info("FlowCreate");
        }

        @Override
        public void onFlowBegin() {
            logger.info("FlowBegin");
        }

        @Override
        public void onFlowComplete() {
            logger.info("FlowComplete");
        }

        @Override
        public void onProcessCreate(TaskProcessor process) {
            logger.info("ProcessCreate {}", process.getName());
        }

        @Override
        public void onProcessTerminate(TaskProcessor process) {
            logger.info("ProcessTerminate {}", process.getName());
        }

        @Override
        public void onProcessPending(TaskHandler handler, TraceRecord trace) {
            logger.info("ProcessPending {}", trace.getProcessName());
        }

        @Override
        public void onProcessSubmit(TaskHandler handler, TraceRecord trace) {
            logger.info("ProcessSubmit {}", trace.getProcessName());
        }

        @Override
        public void onProcessStart(TaskHandler handler, TraceRecord trace) {
            logger.info("ProcessStart {}", trace.getProcessName());
        }

        @Override
        public void onProcessComplete(TaskHandler handler, TraceRecord trace) {
            logger.info("ProcessComplete {}", trace.getProcessName());
        }

        @Override
        public void onProcessCached(TaskHandler handler, TraceRecord trace) {
            logger.info("ProcessCached {}", trace.getProcessName());
        }

        @Override
        public boolean enableMetrics() {
            return false;
        }

        @Override
        public void onFlowError(TaskHandler handler, TraceRecord trace) {
            logger.info("FlowError {}", trace.getProcessName());
        }

        @Override
        public void onFilePublish(Path destination) {
            logger.info("FilePublish {}", destination.toString());
        }

        @Override
        public void onFilePublish(Path destination, Path source) {
            logger.info("FilePublish {} {}", destination.toString(), source.toString());
        }
    }
}
