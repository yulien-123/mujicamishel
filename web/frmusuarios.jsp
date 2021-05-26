<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" >
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

        <title>USUARIOS</title>
    </head>
    <body>
        <div class="container">
            <h1>Formulario de USUARIOS</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="usuarios" />
            </jsp:include>
            <br>
            <form action="UsuariosControlador" method="post" >
                <input type="hidden" name="id" value="${usuarios.id}">
                <div class="form-group">
                    <label for="" class="form-label">Usuario</label>
                    <input type="text" class="form-control" name="usuario" value="${usuarios.usuario}" placeholder="Escriba su usuario">                    
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Correo electrónico</label>
                    <input type="email" class="form-control" name="correo" value="${usuarios.correo}" placeholder="Escriba su correo electrónico">                    
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Clave</label>
                    <input type="text" class="form-control" name="clave" value="${usuarios.clave}" placeholder="Escriba su clave">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>

    </body>
</html>
