<!--
    JBoss, Home of Professional Open Source
    Copyright 2012, Red Hat, Inc. and/or its affiliates, and individual
    contributors by the @authors tag. See the copyright.txt in the 
    distribution for a full listing of individual contributors.
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,  
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 -->
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<portlet:actionURL var="actionURL"/>
<div>
    <form action="<%= actionURL %>" method="POST">
        <div><c:out value="${nodeManagementMessage}"/></div>
        <h3>Add a new navigation sub-node to the present node</h3>
        <div>Node Name <input type="text" name="nodeName"/></div>
        <div>External URL <input type="text" name="externalURI"/></div>
        <div>Open in New Window <input type="checkbox" name="openInNewWindow" value="true"/></div>
        <div><input type="Submit" value="Add Node"/></div>
    </form>
</div>