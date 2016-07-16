1. Example reference from https://netbeans.org/kb/docs/web/mysql-webapp.html
<br>

2. Software and resource: <br>
    <ul>
        <li>Netbeans 8.1</li>
        <li>GlassFish 4.0</li>
        <li>Java EE 5.5</li>
        <li>MySQL</li>
        <li>MySQL Connector/ JDBC Driver</li>
        <li>JSTL, JSP</li>
        <li>HTML, CSS</li>
    </ul>

3. Note: <br>
    <ul>
        <li>Run sql/MyNewDatabase.sql to create database and insert test data.</li>
        <li>In web.xml change content of <b>res-type</b> below:</li>
            <ul>
                <li>javax.sql.DataSource <b>-></b> javax.sql.ConnectionPoolDataSource</li>
            </ul>
        <li>Copy file glassfish-resource.xml to Server Resource (Project)</li>
    </ul>
