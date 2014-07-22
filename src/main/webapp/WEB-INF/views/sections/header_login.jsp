<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav>
    <ul id="globalNav" style="margin: auto; margin-top: 20px; margin-bottom: 20px; padding: 0px;">
        <li><a href="http://www.spoors.in/" title="Spoors"><img src="${pageContext.servletContext.contextPath}/resources/img/logo.png" alt="Spoors Logo" /></a></li>      
        <li><a href="http://www.spoors.in/about_us" title="About Us">About Us</a></li>
        <li><a href="http://www.spoors.in/contact_us" title="Support">Support</a></li>
        <li><a href="http://www.spoors.in/contact_us" title="Contact Us">Contact Us</a></li>
        <li><%-- <a href="${pageContext.servletContext.contextPath}/signup" title="Sign Up">Sign Up</a> --%></li>
        <li><a href="${pageContext.servletContext.contextPath}/login" title="Sign In">Sign In</a></li>
    </ul>
</nav>