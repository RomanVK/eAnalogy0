<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>eAnalogy 0</title>
    </head>

    <body>
        <form action="<c:url value="/main"/>" method="POST">        
            <h1>eAnalogy 0</h1>
            <h2>Search of Circuit Breaker Analogy</h2>
<hr><p>&nbsp;</p>
             
            <table border="1" width="100%" cellpadding="10">
                <tr>
                    <h3>First Step - Search Circuit Breaker</h3>
                </tr>
                <tr>
                    <th>Manufacturer</th>
                    <th>Number of poles</th>
                    <th>Type of tripping characteristic Tm</th>
                    <th>Maximum switching capacity at 380 / 220V Ics, kA</th>
                    <th>Rated current, A</th>
                    <th>Current settings I∆, mA</th>
                    <th>Name</th>
                    <th>Code</th>
                </tr>
                <tr>
                <td>
                        <select name="selManufacturer">
                                <c:forEach var="Manufacturer" items="${form.manufacturerS}">
                                    <c:choose>
                                        <c:when test="${Manufacturer==form.selManufacturer}">
                                                <option value="${Manufacturer}" selected><c:out value="${Manufacturer}"/></option>
                                        </c:when>
                                        <c:otherwise>
                                                <option value="${Manufacturer}"><c:out value="${Manufacturer}"/></option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                        </select>
                </td> 
                <td>
                        <select name="selDbPoleCountEnum">
                                <c:forEach var="DbPoleCountEnum" items="${form.dbPoleCountEnumS}">
                                    <c:choose>                                  
                                        <c:when test="${DbPoleCountEnum==form.selDbPoleCountEnum}">
                                                <option value="${DbPoleCountEnum}" selected><c:out value="${DbPoleCountEnum}"/></option>
                                        </c:when>
                                        <c:otherwise>
                                                <option value="${DbPoleCountEnum}"><c:out value="${DbPoleCountEnum}"/></option>
                                        </c:otherwise>
                                    </c:choose>                                                
                                </c:forEach>
                        </select>
                </td>
                <td>
                        <select name="selAutomatCharReleaseType">
                                <c:forEach var="AutomatCharReleaseType" items="${form.automatCharReleaseTypeS}">
                                    <c:choose>                                  
                                        <c:when test="${AutomatCharReleaseType==form.selAutomatCharReleaseType}">
                                                <option value="${AutomatCharReleaseType}" selected><c:out value="${AutomatCharReleaseType}"/></option>
                                        </c:when>
                                        <c:otherwise>
                                                <option value="${AutomatCharReleaseType}"><c:out value="${AutomatCharReleaseType}"/></option>
                                        </c:otherwise>
                                    </c:choose>                                                
                                </c:forEach>
                        </select>
                </td>
                <td>
                        <select name="selMaxCommutation">
                                <c:forEach var="MaxCommutation" items="${form.maxCommutationS}">
                                    <c:choose>                                                                     
                                        <c:when test="${MaxCommutation==form.selMaxCommutation}">
                                                <option value="${MaxCommutation}" selected><c:out value="${MaxCommutation}"/></option>
                                        </c:when>
                                        <c:otherwise>
                                                <option value="${MaxCommutation}"><c:out value="${MaxCommutation}"/></option>
                                        </c:otherwise>
                                    </c:choose> 
                                </c:forEach>
                        </select>
                </td>
                <td>
                        <select name="selNominalCurrent">
                                <c:forEach var="NominalCurrent" items="${form.nominalCurrentS}">
                                    <c:choose>
                                        <c:when test="${NominalCurrent==form.selNominalCurrent}">
                                                <option value="${NominalCurrent}" selected><c:out value="${NominalCurrent}"/></option>
                                        </c:when>
                                        <c:otherwise>
                                                <option value="${NominalCurrent}"><c:out value="${NominalCurrent}"/></option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                        </select>
                </td>
                <td>
                        <select name="selCurrentScaleUzo">
                                <c:forEach var="CurrentScaleUzo" items="${form.currentScaleUzoS}">
                                    <c:choose>
                                        <c:when test="${CurrentScaleUzo==form.selCurrentScaleUzo}">
                                                <option value="${CurrentScaleUzo}" selected><c:out value="${CurrentScaleUzo}"/></option>
                                        </c:when>
                                        <c:otherwise>
                                                <option value="${CurrentScaleUzo}"><c:out value="${CurrentScaleUzo}"/></option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                        </select>
                </td>
                <td>
                        <select name="selName">
                                <c:forEach var="Name" items="${form.nameS}">
                                    <c:choose>
                                        <c:when test="${Name==form.selName}">
                                                <option value="${Name}" selected><c:out value="${Name}"/></option>
                                        </c:when>
                                        <c:otherwise>
                                                <option value="${Name}"><c:out value="${Name}"/></option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                        </select>
                </td>
                <td>
                        <select name="selCode">
                                <c:forEach var="Code" items="${form.codeS}">
                                    <c:choose>
                                        <c:when test="${Code==form.selCode}">
                                                <option value="${Code}" selected><c:out value="${Code}"/></option>
                                        </c:when>
                                        <c:otherwise>
                                                <option value="${Code}"><c:out value="${Code}"/></option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                        </select>
                </td>
                <tr></tr>
            </table>
            <input type="submit" name="clear" value="Clear"/>
            <input type="submit" name="getItems" value="Search Items"/>

            <table border="1" width="100%" cellpadding="10">
                <tr>
                    <h3>Second Step - Search Analogs</h3>
                </tr>
                <tr>
                    <th>&nbsp;</th>                   
                    <th>Manufacturer</th>
                    <th>Number of poles</th>
                    <th>Type of tripping characteristic Tm</th>
                    <th>Maximum switching capacity at 380 / 220V Ics, kA</th>
                    <th>Rated current, A</th>
                    <th>Current settings I∆, mA</th>
                    <th>Name</th>
                    <th>Code</th>
                </tr>

                <c:forEach var="item" items="${form.items}">
                <tr>
                    <td><input type="radio" name="name" value="${item.name}"></td>
                    <td><c:out value="${item.manufacturer}"/></td>
                    <td><c:out value="${item.dbPoleCountEnum}"/></td>
                    <td><c:out value="${item.automatCharReleaseType}"/></td>
                    <td><c:out value="${item.maxCommutation}"/></td>
                    <td><c:out value="${item.nominalCurrent}"/></td>
                    <td><c:out value="${item.currentScaleUzo}"/></td>
                    <td><c:out value="${item.name}"/></td>
                    <td><c:out value="${item.code}"/></td>      
                </tr>
                </c:forEach>
            </table>

            <input type="submit" name="getAnalogs" value="Search Analogs"/>

            <table border="1" width="100%" cellpadding="10">
                <tr>
                    <h3>Thirst Step - View Analogs And Save Result</h3>
                </tr>
                <tr>
                    <th>Manufacturer</th>
                    <th>Number of poles</th>
                    <th>Type of tripping characteristic Tm</th>
                    <th>Maximum switching capacity at 380 / 220V Ics, kA</th>
                    <th>Rated current, A</th>
                    <th>Current settings I∆, mA</th>
                    <th>Name</th>
                    <th>Code</th>
                </tr>

                <c:forEach var="analog" items="${form.analogs}">
                <tr>
                    <td><c:out value="${analog.manufacturer}"/></td>
                    <td><c:out value="${analog.dbPoleCountEnum}"/></td>
                    <td><c:out value="${analog.automatCharReleaseType}"/></td>
                    <td><c:out value="${analog.maxCommutation}"/></td>
                    <td><c:out value="${analog.nominalCurrent}"/></td>
                    <td><c:out value="${analog.currentScaleUzo}"/></td>
                    <td><c:out value="${analog.name}"/></td>
                    <td><c:out value="${analog.code}"/></td>                 
                </tr>
                </c:forEach>
            </table>

            <input type="submit" name="SaveToExcel" value="Save Result To Excel"/>
            
<hr><p>&nbsp;</p>
        </form>
    </body>

</html>