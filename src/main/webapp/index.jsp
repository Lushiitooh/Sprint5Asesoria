<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <%@ include file="/views/head.jsp" %>
  </head>
  <body>
    <%@ include file="/views/nav-inicio.jsp" %>

    <main class="container">
      <section>
        <div class="card mb-3" style="max-width: 100%;">
          <div class="row g-0">
            <div class="col-s-12 col-md-7">
              <div class="card-body">
                <h5 class="card-title text-center mt-5">Acerca de...</h5>
                <p class="card-text px-5">lorem ipsum</p>
              </div>
            </div>
          </div>
        </div>
      </section>
      <section class="row my-5">
        <div class="col-4 text-center">
          <i class="fa-solid fa-user-shield fa-5x" style="color: #523184;"></i>
          <h3 class="mt-3">Seguridad</h3>
        </div>
        <div class="col-4 text-center">
          <i class="fa-solid fa-microchip fa-5x" style="color: #523184;"></i>
          <h3 class="mt-3">Tecnología</h3>
        </div>
        <div class="col-4 text-center">
          <i class="fa-solid fa-users fa-5x" style="color: #523184;"></i>
          <h3 class="mt-3">Asesorías</h3>
        </div>
      </section>
    </main>

    <jsp:include page="/views/footer.jsp"/>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>
  </body>
</html>