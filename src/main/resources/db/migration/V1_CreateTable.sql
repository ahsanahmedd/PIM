@Bean
public Flyway flyway() {
    Flyway flyway = new Flyway();
    flyway.setDataSource(dataSource);
    flyway.setLocations("filesystem:/db.migrations");
    flyway.setSchemas("my_schema");
return flyway;
}
