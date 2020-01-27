package web.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import domain.PropertyNameSpace;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utils.ProjectConfiguration;

public abstract class BasePage {
    protected static final Logger LOGGER = LogManager.getLogger(BasePage.class);
    protected String urlAppender = "";

    protected BasePage() {
        initBaseUrl();
    }

    protected BasePage(String urlAppender) {
        initBaseUrl();
        this.urlAppender = urlAppender;
    }

    public void open() {
        Selenide.open(urlAppender);
    }

    private void initBaseUrl() {
            Configuration.baseUrl = ProjectConfiguration.getPropertyByEnv(PropertyNameSpace.BASE_URL);
    }
}
