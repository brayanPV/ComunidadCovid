# ComunidadCovid

<p>Las personas que hacen parte de la comunidad académica de la Universidad deben retornar a sus
actividades académicas, para lo que la Universidad debe brindar a su comunidad la tranquilidad en
el acceso a la Universidad para evitar el contagio, para lo cual debe implementar un protocolo
definido por el gobierno que incluye el registro del personal que accede a la institución. Se debe
tener en cuenta que el ingreso es por un código de la empresa, es decir si se va a ingresar a la interfaz
de la Universidad Francisco de Paula Santander seria http://direccion:port/ufps o si fuera
http://direccion:port/colport seria para el colegio donde ufps y colport son los identificadores de
cada empresa o entidad.</p>
<p>
El Sistema inicia con un proceso de validación de credenciales hacia
En el proceso se debe validar contra un servicio en un
endpoint por cada empresa. La estructura del enlace es la
que se observa más adelante, en caso de ser positivo la
autenticación debe crear la persona en el sistema para que
el usuario realice el registro de datos básicos del funcionario
de la comunidad estudiantil. Siempre se debe realizar la
autenticación contra el endpoint de la empresa.</p>
<p>Method: POST
Enlace: siaweb.ufps.edu.co/prueba.php
Parametros de prueba: solo se utiliza el documento y la
clave por POST.
{
"error":false,
"documento":"10101010",
"nombre":"Juan Camilo Gomez Perez",
"tipo":2,
"tipodescripcion":"Estudiante"
}</p>
<table>
<thead>
<tr>
<th>Documento</th>
<th>Clave</th>
<th>Perfil</th>
</tr> 
</thead>
<tbody>
<tr>
<td>1150001 </td>
<td>1234 </td>
<td>Estudiante </td>
</tr>
<tr>
<td>00001 </td>
<td>1234 </td>
<td>Profesor </td>
</tr>
<tr>
<td>90001 </td>
<td>1234 </td>
<td>Administrativo </td>
</tr>
</tbody>
</table>