package org.jboss.quickstarts.portal.jsp;

import java.io.File;
import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.portal.api.PortalTest;
import org.jboss.arquillian.portal.api.PortalURL;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.portletbridge.PortletBridgeConstants;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.descriptor.api.Descriptors;
import org.jboss.shrinkwrap.descriptor.api.webapp30.WebAppDescriptor;
import org.jboss.shrinkwrap.descriptor.api.webcommon30.WebAppVersionType;
import org.jboss.shrinkwrap.portal.api.PortletArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import category.RequiresJSF;

/**
 * @author <a href="http://community.jboss.org/people/kenfinni">Ken Finnigan</a>
 */
@RunWith(Arquillian.class)
@Category(RequiresJSF.class)
@PortalTest
public class JspPortletTest {

    public static final String TEST_NAME = "Joe";

    @Deployment
    public static PortletArchive getDeployment() {
        PortletArchive archive = ShrinkWrap.create(PortletArchive.class, "jsp-portlet-with-ui-tests.war");

        File[] libs = Maven.resolver()
                .loadPomFromFile("pom.xml")
                .resolve("org.jboss.portletbridge:portletbridge-impl")
                .withTransitivity()
                .asFile();

        archive.createSimplePortlet(JspPortletWithUiTests.class);
        archive.addAsLibraries(libs);

        WebAppDescriptor webXml = Descriptors.create(WebAppDescriptor.class)
                .addDefaultNamespaces()
                .version(WebAppVersionType._3_0)
                .createContextParam()
                    .paramName(PortletBridgeConstants.REQUEST_SCOPE_PRESERVED)
                    .paramValue("true")
                    .up();

        archive.setWebXML(new StringAsset(webXml.exportAsString()));

        return archive;
    }

//    @FindBy(xpath = "//input['jsf2HelloWorldPortlet:output' = substring(@id, string-length(@id) - string-length('jsf2HelloWorldPortlet:output'))]")
//    private WebElement outputField;
//
//    @FindBy(xpath = "//input['jsf2HelloWorldPortlet:nameInput' = substring(@id, string-length(@id) - string-length('jsf2HelloWorldPortlet:nameInput'))]")
//    private WebElement nameInputField;

    @ArquillianResource
    @PortalURL
    URL portalURL;

    @Drone
    WebDriver browser;

    @Test
    @InSequence(1)
    @RunAsClient
    public void renderFormPortlet() throws Exception {
        browser.navigate().to(portalURL);
        System.out.println(browser.getCurrentUrl());
        System.out.println(browser.getPageSource());


//        assertEquals(HelloBean.DEFAULT_NAME, nameInputField.getAttribute("value"));
//        assertEquals("Hello "+ HelloBean.DEFAULT_NAME, outputField.getText());

    }

    @Test
    @InSequence(2)
    @RunAsClient
    public void testSubmitAndRemainOnPage() throws Exception {
        browser.navigate().to(portalURL);

//        nameInputField.clear();
//        nameInputField.sendKeys(TEST_NAME);
//
//        assertEquals(TEST_NAME, nameInputField.getAttribute("value"));
//        assertEquals("Hello "+ TEST_NAME, outputField.getText());
//
//        // Re-render page
//        browser.navigate().refresh();
//
//        assertEquals(TEST_NAME, nameInputField.getAttribute("value"));
//        assertEquals("Hello "+ TEST_NAME, outputField.getText());
    }
}