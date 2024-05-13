<%@include file="layout/header.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: minhson
  Date: 13/5/24
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%--
Directive
--%>
<%@page    import="java.util.Random" %>
    <%!
        int counter = 0;
        // Declaration tag
        String convertNumberToTag(int number) {
            if(number < 0) {
                return "";
            }
            if(number <=6) {
                String headingTag = "h" + Integer.toString(number);
                return "<" + headingTag + ">Heading " + number + "</" + headingTag + ">";
            }
            return "<h6>Heading " + Integer.toString(number) + "</h6>";
        }

        int randomANumberGTETargetNumber(int targetNumber){
            // reset counter;
            counter = 0;
            int returnedValue = 0;
            if(targetNumber <= returnedValue){
                return targetNumber;
            }
            while(returnedValue < targetNumber) {
                returnedValue = new Random().nextInt(targetNumber) + 1;
                counter += 1;
            }
            return returnedValue;
        }
    %>
    <%-- Expression Tag --%>
    <p>Number of times need to random the target number:<%= counter %></p>
    <%
        // Scriptlet tag
        int n = randomANumberGTETargetNumber(10);
        for (int i = 0; i < n; i++) {
            out.println(convertNumberToTag(i+1));
        }
    %>
<%@include file="layout/footer.jsp"%>
