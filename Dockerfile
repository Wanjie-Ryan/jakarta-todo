FROM airhacks/glassfish
COPY ./target/Todo.war ${DEPLOYMENT_DIR}
