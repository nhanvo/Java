Example reference from https://netbeans.org/kb/docs/web/mysql-webapp.html
Software and resource:
    - Netbeans 8.1
    - GlassFish 4.0
    - Java EE 5.5
    - MySQL
    _ MySQL Connector/ JDBC Driver
    - JSTL, JSP
    - HTML, CSS
Note:
    - Run sql/MyNewDatabase.sql to create database and insert test data.
    - In web.xml change content to below: 
        <resource-ref>
            <res-ref-name>jdbc/WEBDEMO</res-ref-name>
            <res-type>javax.sql.ConnectionPoolDataSource</res-type>
            <res-auth>Container</res-auth>
            <res-sharing-scope>Shareable</res-sharing-scope>
        </resource-ref>
    - Copy file glassfish-resource.xml to Server Resource (Project)
