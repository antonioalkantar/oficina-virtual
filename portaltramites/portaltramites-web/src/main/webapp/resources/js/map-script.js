			
			//Se utiliza JQuery para identificar cuando la pagina ya haya concluido su carga sino no encuentra siempre el componente w_gmap
			

			function configuraMapa(){
// 				console.log('Configurando mapa...');
				//1. En el componente GMap de Primefaces se establecio que su widget se llama w_gmap entonces se busca y se obtiene su objeto Map
		    	var gmap = PF('w_gmap').getMap();
		    	
				if(gmap == null){
					console.log('gmap null');
				}else{
					console.log('gmap obtenido');
				}
				
		    	var CDMX_BOUNDS = {
		    			north: 19.904245,
		    	        south: 18.596012,
		    	        west: -99.503562,
		    	        east: -98.835598,
		    	      };

		    	// gestureHandling: Para que el mapa no pida presionar Ctrl + mouse para hacer zoom
		    	// restriction: Para que el usuario no pueda hacer zoom-out o navegar en el mapa fuera del rango permitido de la CDMX
		    	// latLngBounds: Los puntos georgraficos que se restringiran
		    	// strictBounds: False indica que sea un poco relajado la restricción para que el usuario pueda hacer zoom para ver toda la zona restringida. Si se pone en true puede ser que no pueda ver el mapa completo de un solo golpe
				var optionsMap = {
						    gestureHandling: 'greedy', 
					    	restriction: {
					            latLngBounds: CDMX_BOUNDS,
					            strictBounds: false,
					        },    
						};
		    	gmap.setOptions(optionsMap);

		    	console.log('gmap con options seteadas');
		    			    	

		         //2. Al cargar el mapa se ocultan todos los markers de restaurantes, tiendas, etc
		        var noPoi = [
		        	{
		        	    featureType: "poi",
		        	    stylers: [
		        	      { visibility: "off" }
		        	    ]   
		        	  }
		        	];
		         gmap.setOptions({styles: noPoi}); 
				
			}		     
		    
		    function reloadOpciones() {		
		    	location.reload();		       	       
		    }		  
		    