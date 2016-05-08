package icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tareas;

import icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tools.conversacion;
import icaro.aplicaciones.recursos.comuSONIAChat.ItfUsoComuSONIAChat;
import icaro.aplicaciones.informacion.gestionCitas.FocoUsuario;
import icaro.aplicaciones.informacion.gestionQuedadas.Notificacion;
import icaro.aplicaciones.informacion.gestionCitas.NotificacionMedico;
import icaro.aplicaciones.informacion.gestionCitas.NotificacionPaciente;
import icaro.aplicaciones.informacion.gestionCitas.VocabularioGestionCitas;
import icaro.aplicaciones.recursos.comunicacionChat.ItfUsoComunicacionChat;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaComunicacion;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

/**
 *
 * @author Francisco J Garijo
 */
public class NotificarAlUsuarioSinContexto extends TareaSincrona {
	private Objetivo contextoEjecucionTarea = null;
	@Override
	public void ejecutar(Object... params) {

		String identDeEstaTarea = this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		FocoUsuario foUsuario = (FocoUsuario) params[0];
		String mensajeAenviar = "";
		try {
			ItfUsoComuSONIAChat recComunicacionChat = (ItfUsoComuSONIAChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ
					.obtenerInterfazUso(VocabularioGestionCitas.IdentRecursoComunicacionChat);
			
			if(foUsuario.intentos < 3){
				mensajeAenviar = conversacion.msg("sincontexto");
				foUsuario.intentos = foUsuario.intentos+1;
			}else{
				if(foUsuario.getFoco().getgoalId().equals("ObtenerIDGrupo")){
					mensajeAenviar = conversacion.msg("peticionIDGrupoImperativo");
					foUsuario.intentos =0 ;
				}else if(foUsuario.getFoco().getgoalId().equals("ObtenerNombre")){
					mensajeAenviar = conversacion.msg("solicitarNombreImperativo");
					foUsuario.intentos =0 ;
				}else if(foUsuario.getFoco().getgoalId().equals("DistribuirMensaje")){
					mensajeAenviar = conversacion.msg("solicitarAccionImperativo");
					foUsuario.intentos =0 ;
				}else if(foUsuario.getFoco() == null){
					mensajeAenviar = conversacion.msg("");
					foUsuario.intentos =0 ;
				}
				
			}
			
			if (recComunicacionChat != null) {
			
				recComunicacionChat.comenzar(identAgenteOrdenante);
				recComunicacionChat.enviarMensagePrivado(
						mensajeAenviar);
			} else {
				identAgenteOrdenante = this.getAgente().getIdentAgente();
				this.generarInformeConCausaTerminacion(
						identDeEstaTarea,
						contextoEjecucionTarea,
						identAgenteOrdenante,
						"Error-AlObtener:Interfaz:"
								+ VocabularioGestionCitas.IdentRecursoComunicacionChat,
						CausaTerminacionTarea.ERROR);
			}
			
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
