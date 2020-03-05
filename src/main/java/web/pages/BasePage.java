package web.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import configuration.domain.PropertyNameSpace;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import configuration.ProjectConfiguration;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BasePage {
    protected static final Logger LOGGER = LogManager.getLogger(BasePage.class);
    protected URL absoluteUrl = null;
    protected String urlAppender = "";

    public BasePage() {
        initBaseUrl();
    }

    public BasePage(String urlAppender) {
        initBaseUrl();
        this.urlAppender = urlAppender;
    }

    public void open() {
        if (absoluteUrl == null) {
            Selenide.open(urlAppender);
        } else {
            Selenide.open(absoluteUrl);
        };
        LOGGER.info(this.getClass().getName() + " was opened.");
    }

    public void setAbsoluteUrl(String absoluteUrl) {
        try {
            this.absoluteUrl = new URL(absoluteUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getPageUrl() {
        if (absoluteUrl == null) {
            return ProjectConfiguration.getPropertyByEnv(PropertyNameSpace.BASE_URL) + urlAppender;
        } else {
            return absoluteUrl.toString();
        }
    }

    private void initBaseUrl() {
            Configuration.baseUrl = ProjectConfiguration.getPropertyByEnv(PropertyNameSpace.BASE_URL);
    }
}
