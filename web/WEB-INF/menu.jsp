<%
    String opcion =  request.getParameter("opcion");
%>
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("Usuarios") ?  "active" : "") %>" href="usuarios.jsp">Form Usuarios</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("Roles") ?  "active" : "") %>" href="UsuariosControlador">Usuarios</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= (opcion.equals("Permisos") ?  "active" : "") %>" href="roles.jsp">Roles</a>
                </li>
            </ul>