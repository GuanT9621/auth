package com.guan.sso.server.grpc;

import com.guan.sso.server.grpc.service.SsoService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class GrpcServer implements CommandLineRunner {

    private final static Logger logger = LoggerFactory.getLogger(GrpcServer.class);

    @Autowired
    private SsoService ssoService;

    @Value("${rpc.server.port}")
    private int port;

    private Server server;

    @Override
    public void run(String... args) throws Exception {
        server = ServerBuilder.forPort(port)
                .addService(ssoService)
                .build().start();

        logger.info("Server started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                logger.info("*** shutting down gRPC server since JVM is shutting down");
                GrpcServer.this.stop();
                logger.info("*** server shut down");
            }
        });

    }

    private void stop() {
        if (server != null) {
            server.shutdown();
            logger.info("Server destroyed ");
        }
        logger.info("Server have died");
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
            logger.info("Server blockUntilShutdown ");
        }
        logger.info("Server have blockUntilShutdown ");
    }

}
