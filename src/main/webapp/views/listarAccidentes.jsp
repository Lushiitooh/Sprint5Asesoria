<%@ page import="com.example.modulo5.model.Accidente" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"/>
<style>
    label.error {
        color: red;
        font-style: italic;
    }
</style>
<body>

<%@ include file='header.jsp' %>

<div class="container mt-5" style="min-height: 750px;">

    <div class="row">
        <div class="col-lg-4 col-sm-12">
            <form method="GET" action="" id="">
                <div class="col d-grid mb-3">
                    <button type="submit" class="btn btn-primary">Ingresar nuevo accidente</button>
                </div>
            </form>
        </div>
    </div>
    <div class="row mb-3">
        <h1 class="text-center mb-3">Listado de Accidentes</h1>
        <div class="col-12 table-responsive">
            <table class="table table-striped table-hover" id="tablaAccidente">
                <thead>
                <tr>
                    <th>ID Accidente</th>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Trabajador Afectado</th>
                    <th>Tipo</th>
                    <th>Cliente</th>
                    <th>Fecha Ingreso</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>

                <%
                    List<Accidente> listaAccidentes = (List) request.getAttribute("accidentes");

                    for (Accidente accidente : listaAccidentes) {
                %>
                <tr>
                    <td class="text-center"><%= accidente.getId() %></td>
                    <td><%= accidente.getFechaAccidente() %></td>
                    <td><%= accidente.getHoraAccidente() %></td>
                    <td><%= accidente.getNombreTrabajador() %></td>
                    <td><%= accidente.getTipoAccidente() %></td>
                    <td><%= accidente.getNombreCliente() %></td>
                    <td class="text-center"><%= accidente.getFechaIngreso() %></td>
                    <td>
                        <div class="row">
                            <div class="col-sm-12 col-lg-4 d-grid mb-3">
                                <button class="btn btn-info btnModalEditar" data-bs-toggle="modal" data-bs-target="#modalEditar"
                                        data-id="<%= accidente.getId() %>"
                                        data-fecha="<%= accidente.getFechaAccidente() %>"
                                        data-hora="<%= accidente.getHoraAccidente() %>"
                                        data-trabajador="<%= accidente.getIdTrabajador() %>"
                                        data-lugar="<%= accidente.getLugarAccidente() %>"
                                        data-descripcion="<%= accidente.getDescripcionAccidente() %>"
                                        data-tipo="<%= accidente.getTipoAccidente() %>"
                                        data-cliente="<%= accidente.getIdCliente() %>"
                                        data-fecha-ingreso="<%= accidente.getFechaIngreso() %>">Editar</button>
                            </div>
                            <div class="col-sm-12 col-lg-4 d-grid mb-3">
                                <button id="btnModalBorrar" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="">Borrar</button>
                            </div>
                        </div>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>

</div>

<div class="modal fade" id="modalBorrar" tabindex="-1" aria-labelledby="etiquetaModal1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="etiquetaModal1">Se requiere confirmación</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Confirma la eliminación del accidente.
            </div>
            <div class="modal-footer">
                <form method="post" action="EliminarAccidenteSv" id="formEliminarAccidente">
                    <input type="text" name="action" value="delete" hidden>
                    <input type="text" name="idDelete" id="idEliminacion" hidden>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" aria-label="Close">Cancelar</button>
                    <button type="submit" class="btn btn-danger" id="btnConfirmarBorrar">Confirmar</button>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade " id="modalEditar" tabindex="-1" aria-labelledby="etiquetaModal2" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="etiquetaModal2">Editar Accidente</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="container" style="height: 750px;">
                    <div class="row d-flex justify-content-center justify-content-center">
                        <div class="col-lg-12 col-sm-12 rounded shadow p-3">
                            <form method="post" action="EditarAccidenteSv" id="formEditarAccidente">
                                <div class="row">
                                    <div class="mb-3 col-lg-4">
                                        <label for="inputID" class="form-label">ID Accidente</label>
                                        <input type="number" class="form-control" id="inputID" name="id" readonly="readonly">
                                    </div>
                                    <div class="mb-3 col-lg-4">
                                        <label for="inputFechaIng" class="form-label">Fecha de ingreso</label>
                                        <input type="date" class="form-control" id="inputFechaIng" name="fechaIngreso" readonly="readonly">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="mb-3 col-lg-6">
                                        <label for="inputFecha" class="form-label">Fecha del Accidente</label>
                                        <input type="text" class="form-control" id="inputFecha" name="fecha">
                                    </div>
                                    <div class="mb-3 col-lg-6">
                                        <label for="inputHora" class="form-label">Hora del Accidente</label>
                                        <input type="text" class="form-control" id="inputHora" name="hora">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="mb-3 col-lg-6">
                                        <label for="inputCliente" class="form-label">Cliente</label>
                                        <input type="text" class="form-control" id="inputCliente" name="cliente">
                                    </div>
                                    <div class="mb-3 col-lg-6">
                                        <label for="inputTrabajador" class="form-label">Trabajador accidentado</label>
                                        <select name="trabajador" id="inputTrabajador" class="form-control">
                                            <option value="1">1</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="mb-3 col-lg-12">
                                    <label for="inputLugar" class="form-label">Lugar del Accidente</label>
                                    <input type="text" class="form-control" id="inputLugar" name="lugar">
                                </div>
                                <div class="mb-3 col-lg-12">
                                    <label for="inputDescripcion" class="form-label">Descripción de los hechos</label>
                                    <textarea class="form-control" id="inputDescripcion" name="descripcion"></textarea>
                                </div>
                                <div class="mb-3">
                                    <label for="inputTipoAccidente" class="form-label">Tipo de Accidente</label>
                                    <input type="text" class="form-control" id="inputTipoAccidente" name="tipoAccidente">
                                </div>
                                <div class="row">
                                    <div class="d-grid col-lg-3">
                                        <button type="submit" id="btnConfirmarEditar" class="btn btn-success">Guardar</button>
                                    </div>
                                    <div class="d-grid col-lg-3">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" aria-label="Close">Cancelar</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>

<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js" integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script>
    var table = $('#tablaAccidentes').DataTable()
    $(document).ready(function() {
        $('#tablaAccidentes tbody').on('click', 'tr', function () {
            if ($(this).hasClass('selected')) {
                $(this).removeClass('selected')
                $(this).removeClass('table-primary')
                $('#btnModalBorrar').attr('data-bs-target', '')
                $('#btnModalEditar').attr('data-bs-target', '')
            } else {
                table.$('tr.selected').removeClass('selected')
                table.$('tr.table-primary').removeClass('table-primary')
                $(this).addClass('selected')
                $(this).addClass('table-primary')
                $('#btnModalBorrar').attr('data-bs-target', '#modalBorrar')
                $('#btnModalEditar').attr('data-bs-target', '#modalEditar')
            }
        })

        $('#btnModalBorrar').click(function () {
            console.log("btnModalBorrar");
            var data = table.row('.selected').data()
            var seleccionadas = table.rows('.selected').data().length
            if (seleccionadas) {
                $('#idEliminacion').val(data[0])
            }
        })
        $('.btnModalEditar').click(function () {
            var btn = $(this);
            $('#inputID').val(btn.data('id'));
            $('#inputFecha').val(btn.data('fecha'));
            $('#inputHora').val(btn.data('hora'));
            $('#inputTrabajador').val(btn.data('trabajador'));
            $('#inputLugar').val(btn.data('lugar'));
            $('#inputDescripcion').val(btn.data('descripcion'));
            $('#inputTipoAccidente').val(btn.data('tipo'));
            $('#inputCliente').val(btn.data('cliente'));
            $('#inputFechaIng').val(btn.data('fecha-ingreso'));
        })
        $.validator.addMethod("fechaSuperiorActual", function(value) {
            var fechaIngresada = new Date(value);
            var fechaActual = new Date();
            return fechaIngresada <= fechaActual;
        }, "La fecha debe ser igual o inferior a la fecha actual.");

        $("#formEditarAccidente").validate({
            rules: {
                fecha: {
                    required: true,
                    fechaSuperiorActual: true
                },
                hora: {
                    required: true,
                    hora: true
                },
                trabajador: {
                    required: true
                },
                lugar: {
                    minlength: 10,
                    required: true
                },
                descripcion: {
                    minlength: 50,
                    required: true
                },
                tipo: {
                    required: true
                },
                cliente: {
                    required: true,
                }
            }
        })

        jQuery.extend(jQuery.validator.messages, {
            required: "Este campo es obligatorio.",
            number : "Este campo debe contener solo números",
            minlength: jQuery.validator.format("Ingresa al menos {0} carácteres."),
            min: jQuery.validator.format("Ingresa un valor minimo de {0}."),
        })
    })
</script>
</body>
</html>

