/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.quickstarts.portal.jsp;

import java.io.IOException;
import java.util.logging.Logger;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Navigation portlet implemented using the GateIn navigation API.
 *
 * @author <a href="mailto:vrockai@redhat.com">Viliam Rockai</a>
 */
public class JspPortletWithUiTests extends GenericPortlet {
    private static final Logger log = Logger.getLogger(JspPortletWithUiTests.class.getName());

    /**
     * This method serves VIEW mode of the JSP portlet. It does nothing else than delegating to {@code "/jsp/jsp-portlet-with-ui-tests.jsp"}.
     *
     * @see javax.portlet.GenericPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
     * @param request the portlet request
     * @param response the render response
     * @throws PortletException if the portlet cannot fulfilling the request
     * @throws IOException if the streaming causes an I/O problem
     */
    @Override
    protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        log.info("Invoking /jsp/jsp-portlet-with-ui-tests.jsp");
        PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/jsp/jsp-portlet-with-ui-tests.jsp");
        prd.include(request, response);
    }

}
