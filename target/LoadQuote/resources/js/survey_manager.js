jQuery(document).ready(function() {
   jQuery('.ui-menuitem-link').each(function(){
       if(window.location.pathname.indexOf(jQuery(this).attr('href')) != -1) {
            jQuery(this).addClass( "menu-selected" );  
       }
   });  
}) 

jQuery(document).ready(function() {
jQuery('td.selectionDisabled').attr('title','Data impostazione non valorizzata');
	jQuery('td.selectionDisabled').css('background-image', 'url(../resources/img/checkbox_disable.png)');
	jQuery('td.selectionDisabled').css('background-repeat', 'no-repeat');
	jQuery('td.selectionDisabled').css('background-position', '10px');
}) 	



function disabilitaSelezione(){
	jQuery('td.selectionDisabled').attr('title','Data impostazione non valorizzata');
	jQuery('td.selectionDisabled').css('background-image', 'url(../resources/img/checkbox_disable.png)');
	jQuery('td.selectionDisabled').css('background-repeat', 'no-repeat');
	jQuery('td.selectionDisabled').css('background-position', '10px');
return false;
}

function disabilitaSelezioneCliente(){
	jQuery('td.selectionDisabled').attr('title','Impossibile selezionare clienti diversi.');
	jQuery('td.selectionDisabled').css('background-image', 'url(../resources/img/checkbox_disable.png)');
	jQuery('td.selectionDisabled').css('background-repeat', 'no-repeat');
	jQuery('td.selectionDisabled').css('background-position', '10px');
return false;
}

PrimeFaces.locales['it'] = {  
        closeText: 'Chiudi',  
        prevText: 'indietro',  
        nextText: 'avanti',  
        currentText: 'oggi',  
        monthNames: ['Gennaio','Febbraio','Marzo','Aprile','Maggio','Giugno', 'Luglio','Agosto','Settembre','Ottobre','Novembre','Dicembre'],  
        monthNamesShort: ['Gen','Feb','Mar','Apr','Mag','Giu', 'Lug','Ago','Set','Ott','Nov','Dic'],  
        dayNames: ['Domenica','Lunedi','Martedi','Mercoledi','Giovedi','Venerdi','Sabato'],  
        dayNamesShort: ['Dom','Lun','Mar','Mer','Gio','Ven','Sab'],   
        weekHeader: 'Settimana',  
        firstDay: 1,  
        isRTL: false,  
        showMonthAfterYear: false,  
        yearSuffix: '',  
        month: 'Mese',  
        week: 'Settimana',  
        day: 'Giorno',  
        allDayText : 'Tutti i giorni',
        timeOnlyTitle: 'Solo Tempo', 
        timeText: 'Ora', 
        hourText: 'Ore', 
        minuteText: 'Minuto', 
        secondText: 'Secondo',
        MONTHS: ['Gennaio','Febbraio','Marzo','Aprile','Maggio','Giugno', 'Luglio','Agosto','Settembre','Ottobre','Novembre','Dicembre'],
	    MONTHS_SHORT: ['Gen','Feb','Mar','Apr','Mag','Giu', 'Lug','Ago','Set','Ott','Nov','Dic'],
	    DAYS: ['Domenica','Lunedi','Martedi','Mercoledi','Giovedi','Venerdi','Sabato'], 
	    DAYS_SHORT:  ['Dom','Lun','Mar','Mer','Gio','Ven','Sab'],  
	    ZOOM_IN: "Aumentare lo zoom",
	    ZOOM_OUT: "Diminuire lo zoom",
	    MOVE_LEFT: "Muovere a sinistra",
	    MOVE_RIGHT: "Muovere a destra",
	    NEW: "Nuovo",
	    CREATE_NEW_EVENT: "Creare nuovo evento",	    
	    months: ['Gennaio','Febbraio','Marzo','Aprile','Maggio','Giugno', 'Luglio','Agosto','Settembre','Ottobre','Novembre','Dicembre'],
	    months_short: ['Gen','Feb','Mar','Apr','Mag','Giu', 'Lug','Ago','Set','Ott','Nov','Dic'],
	    days: ['Domenica','Lunedi','Martedi','Mercoledi','Giovedi','Venerdi','Sabato'], 
	    days_short:  ['Dom','Lun','Mar','Mer','Gio','Ven','Sab'],  
	    zoom_in: "Aumentare lo zoom",
	    zoom_out: "Diminuire lo zoom",
	    move_left: "Muovere a sinistra",
	    move_right: "Muovere a destra",
	    new: "Nuovo",
	    create_new_event: "Creare nuovo evento"
    };  

function  chiudiStatus(){
//	    jQuery('td.selectionDisabled').attr('title','Data impostazione non valorizzata');
//		jQuery('td.selectionDisabled').css('background-image', 'url(../resources/img/checkbox_disable.png)');
//		jQuery('td.selectionDisabled').css('background-repeat', 'no-repeat');
//		jQuery('td.selectionDisabled').css('background-position', '10px');
	try {
		PF('statusDialog').hide();
	} catch (e) {
	}
	
	return false;
}

function  chiudiDialogLog(){
	try {
		PF('logSelectedvar').hide();
	} catch (e) {
	}
	
	return false;
}

function handleRequiredValue(xhr, status, args) {
  //  if(args.validationFailed || !args.loggedIn) {
	
	 if(args.validationFailed) {
    	PF('statusDialog').hide();
        PF('confirmvar').jq.effect("shake", {times:5}, 100);
    }
    else {
    	alert("bottone nascosto jqueery");
    	   jQuery('#bottone-nascosto').click();
       // PF('confirmvar').hide();
    }
}


function showStatus() {
    PF('statusDialog').show();
}
function hideStatus() {
    PF('statusDialog').hide();
}


function showCalendar() {
jQuery("#div-list").hide(500);
jQuery("#div-chart").hide(500);
jQuery("#div-calendar").show(500);
}


function showTable() {
jQuery("#div-calendar").hide(500);
jQuery("#div-chart").hide(500);
jQuery("#div-list").show(500);
}

function showChart() {
jQuery("#div-calendar").hide(500);
jQuery("#div-list").hide(500);
jQuery("#div-chart").show(500);
}

function pieExtender() {
    this.cfg.highlighter = {
        show: true,
        tooltipLocation: 'n',
        useAxesFormatters: false,
        formatString: '%s = %d'
    };
}



function enableButtonPrint(){
jQuery('#print-button').attr('disabled',false);  
}

function disableButtonPrint(){
	jQuery('#print-button').attr('disabled',true);  
}

function hideStatusEtichette() {
	 PF('statusDialog').hide();
	    jQuery('td.selectionDisabled').attr('title','Data impostazione non valorizzata');
		jQuery('td.selectionDisabled').css('background-image', 'url(../resources/img/checkbox_disable.png)');
		jQuery('td.selectionDisabled').css('background-repeat', 'no-repeat');
		jQuery('td.selectionDisabled').css('background-position', '10px');
		hideStatusEtichetteRemote();
}

function hideStatusDistinte() {
	    PF('statusDialog').hide();
	    jQuery('td.selectionDisabled').attr('title','Data impostazione non valorizzata');
		jQuery('td.selectionDisabled').css('background-image', 'url(../resources/img/checkbox_disable.png)');
		jQuery('td.selectionDisabled').css('background-repeat', 'no-repeat');
		jQuery('td.selectionDisabled').css('background-position', '10px');	
		hideStatusDistinteRemote();
}

function hideStatusDistintePreview() {
    PF('statusDialog').hide();
    jQuery('td.selectionDisabled').attr('title','Data impostazione non valorizzata');
	jQuery('td.selectionDisabled').css('background-image', 'url(../resources/img/checkbox_disable.png)');
	jQuery('td.selectionDisabled').css('background-repeat', 'no-repeat');
	jQuery('td.selectionDisabled').css('background-position', '10px');	
	PF('confirmvarPreview').hide(); 
}

function hideStatusDistinteReprint() {
    PF('statusDialog').hide();
    jQuery('td.selectionDisabled').attr('title','Data impostazione non valorizzata');
	jQuery('td.selectionDisabled').css('background-image', 'url(../resources/img/checkbox_disable.png)');
	jQuery('td.selectionDisabled').css('background-repeat', 'no-repeat');
	jQuery('td.selectionDisabled').css('background-position', '10px');	
	PF('distintaSelectedVar').hide(); 
}


function showTableResultEtichette() {
	jQuery("#blocco-selezione").hide(500);
	jQuery("#table-block-confirmed").show(500);
}

function showTableEtichette() {
	jQuery("#table-block-confirmed").hide(500);
	jQuery("#blocco-selezione").show(500);
	}


function hideStatusFiles() {
	    PF('statusDialog').hide();
		//hideStatusReprintFile();
		PF('distintaSelectedvar').hide(); 
}


function customExtenderNoLegend(){
	 this.cfg.grid = {
		       background: '#FFF' //Set background to white
		    };
   this.cfg.legend= {
		   	   show: false
   			};
}

function horizontalExtender(){
	 this.cfg.grid = {
		       background: '#FFF' //Set background to white
		    };
  this.cfg.legend= {
		   	   show: false
  			};
 
}



function customExtender () {
    this.cfg.grid = {
       background: '#FFF' //Set background to white
    };
    
//    this.cfg.legend= {
//            show: true,
//            location: 's',
//            placement: 'outsideGrid'
//        };
}

function customExtenderFinite () {
    this.cfg.grid = {
       background: '#FFF' //Set background to white
    };
    
//    this.cfg.legend= {
//            show: true,
//            location: 's',
//            placement: 'outsideGrid'
//        };
}

function ext1() {
    this.cfg.seriesDefaults = {
        renderer : $.jqplot.PieRenderer,
        rendererOptions : {
            // rotate the starting position of the pie around to 12 o'clock.
            startAngle : -90
        }
    };
};


function customExtenderDonut () {
    this.cfg.grid = {
       background: '#FFF', //Set background to white
       borderColor: 'white', shadow: false, drawBorder: true
    };
    
    this.cfg.legend= {
            show: false
        };
    
//    this.cfg.seriesDefaults = {
//    	      // make this a donut chart.
//    	      renderer:$.jqplot.DonutRenderer,
//    	      rendererOptions:{          
//    	          thickness: 26,
//    	          ringMargin: 0,
//    	          fill: true,
//    	          padding: 0,
//    	          sliceMargin: 4,
//    	          // Pies and donuts can start at any arbitrary angle.
//    	          startAngle: -90,
//
//    	        // By default, data labels show the percentage of the donut/pie.
//    	        // You can show the data 'value' or data 'label' instead, or 'percent'
//    	        dataLabels: 'value',
//    	        showDataLabels: false,
//    	        totalLabel: true
//    	      }
//    	   }  
};



    

jQuery(document).ready(function () {
	jQuery('#nav > li > a').click(function(event){
	    if ($(this).attr('class') != 'active'){
	    	jQuery('#nav li ul').slideUp();
	    	jQuery(this).next().slideToggle();
	    	jQuery('#nav li a').removeClass('active');
	    	jQuery(this).addClass('active');	    	
	    }
	  });
	});

jQuery(document).ready(function (jQuery) {
    var url = window.location.href;
    var activePage = url;
    jQuery('#nav a').each(function () {
        var linkPage = this.href;
        if (activePage == linkPage) {
        	jQuery(this).addClass('active_li');	
        	jQuery(this).closest("li").addClass("active");  
        	jQuery(this).closest( "ul" ).slideToggle();
        }
    });
});

function w3_open() {
  document.getElementById("sidebar").style.display = "block";
  
  
  jQuery("#form_div").animate({
	    'marginLeft': '15%'
	}, 500);
	
	jQuery("#titolo").animate({
	    'marginLeft': '15%'
	}, 500);
	
	jQuery(".x").animate({
	    'marginLeft': '28%'
	}, 500);
	
	jQuery(".x-right").animate({
	    'marginLeft': '28%'
	}, 500);
	
	
	
  //document.getElementById("content_home").style.marginLeft = "15%";
  document.getElementById("form_div").style.width = "90%"; 
  //document.getElementById("titolo").style.marginLeft = "15%";
  document.getElementById("titolo").style.width = "90%"; 
}

function w3_close() {
		
	jQuery("#form_div").animate({
	    'marginLeft': '0%'
	}, 500);
	
	jQuery("#titolo").animate({
	    'marginLeft': '0%'
	}, 500);
	
	
	jQuery(".x").animate({
	    'marginLeft': '24%'
	}, 500);
	
	jQuery(".x-right").animate({
	    'marginLeft': '24%'
	}, 500);
	
  document.getElementById("sidebar").style.display = "none";
//  document.getElementById("content_home").style.marginLeft = "0%";
  document.getElementById("form_div").style.width = "100%"; 
 // document.getElementById("titolo").style.marginLeft = "0%";
  document.getElementById("titolo").style.width = "100%"; 
}



jQuery(document).ready(function (jQuery) {
	jQuery('#spnTop').on("click",function() {
		jQuery('html, body').animate({ scrollTop: 0 }, 'slow', function () {
	    });
	});
});




