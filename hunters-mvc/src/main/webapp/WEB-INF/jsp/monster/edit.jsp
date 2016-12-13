<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="Edit monster">
    <jsp:attribute name="body">
        <form:form method="post" action="${pageContext.request.contextPath}/monster/update/${monsterToUpdate.id}"
                   modelAttribute="monsterToUpdate" cssClass="form-horizontal">
            <div class="monster-form-group">
                <div class="monster-input-error">
                    <form:errors path="name" cssClass="help-block"/>
                </div>
                <form:label path="name" cssClass="monster-view-attrib">Name</form:label>
                <form:input path="name" cssClass="monster-input" value="${monsterToUpdate.name}"/>
            </div>
            <div class="monster-form-group">
                <div class="monster-input-error">
                    <form:errors path="height" cssClass="help-block"/>
                </div>
                <form:label path="height" cssClass="monster-view-attrib">Height</form:label>
                <form:input path="height" cssClass="monster-input" value="${monsterToUpdate.height}" />
            </div>
            <div class="monster-form-group">
                <div class="monster-input-error">
                    <form:errors path="weight" cssClass="error"/>
                </div>
                <form:label path="weight" cssClass="monster-view-attrib">Weight </form:label>
                <form:input path="weight" cssClass="monster-input" value="${monsterToUpdate.weight}"/>
            </div>
            <div class="monster-form-group">
                <div class="monster-input-error">
                    <form:errors path="power" cssClass="error"/>
                </div>
                <form:label path="power" cssClass="monster-view-attrib">Power</form:label>
                <form:input path="power" cssClass="monster-input" value="${monsterToUpdate.power}"/>
            </div>
            <div class="monster-form-group">
                <form:label path="location" cssClass="monster-view-attrib">Location</form:label>
                <form:select path="location" cssClass="monster-select">
                    <form:options items="${locationList}" itemLabel="name" itemValue="id"/>
                </form:select>
            </div>
            <div class="monster-form-group">
                <div class="monster-input-error">
                    <form:errors path="types" cssClass="error"/>
                </div>
                <form:label path="types" cssClass="monster-view-attrib">Monster types</form:label>
                <div/>
                <form:checkboxes path="types" items="${monsterTypes}" element="span class='monster-checkbox'"/>

            </div>
            <div class="box-footer" style="text-align: right;">
                <button type="submit" class="btn btn-primary" >Update monster</button>
            </div>
        </form:form>
    </jsp:attribute>
</my:pagetemplate>