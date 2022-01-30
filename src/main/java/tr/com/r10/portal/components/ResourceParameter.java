package tr.com.r10.portal.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ResourceParameter {
    @Value("${datasource.jpa.driver}")
    private String dataSourceDriver;
    @Value("${datasource.jpa.url}")
    private String dataSourceUrl;
    @Value("${datasource.jpa.username}")
    private String dataSourceUser;
    @Value("${datasource.jpa.password}")
    private String dataSourcePassword;

    public String getDataSourceDriver() {
        return dataSourceDriver;
    }

    public String getDataSourceUrl() {
        return dataSourceUrl;
    }

    public String getDataSourceUser() {
        return dataSourceUser;
    }

    public String getDataSourcePassword() {
        return dataSourcePassword;
    }
}