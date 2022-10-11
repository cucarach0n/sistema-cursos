/**
 * Toggle Navbar
 */
const $navbar = document.getElementById('navbar')
const $toggleNavbar = document.getElementById('toggle-navbar')
const $navbarClose = document.getElementById('navbar-close')

const handleToggleNavbarVisibility = e => {
  $navbar.classList.toggle('show')
}

if($toggleNavbar) {
  $toggleNavbar.addEventListener('click', handleToggleNavbarVisibility)
  $navbarClose.addEventListener('click', handleToggleNavbarVisibility)
}

/**
 * Material Input
 */
 class MaterialInputs {
  constructor(selector = '.material-input input') {
    this.materialInputs = Array.from(document.querySelectorAll(selector));
    this.events();
  }
  events() {
    this.materialInputs.forEach(input => {
      input.addEventListener('input', () => {
        if(input.value !== '') {
          input.classList.add('non-empty');
        }else {
          input.classList.remove('non-empty');
        }
      });
    });
  }
}

new MaterialInputs();

/**
 * Slider
 */
$('#whychoseus').owlCarousel({
  loop:true,
  margin:20,
  nav:true,
  navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
  dots: false,
  responsive:{
      0:{
          items:1,
          stagePadding: 50
      },
      600:{
          items:2
      },
      1000:{
          items:4
      }
  }
});

/**
 * TABS
 */
 class Tabs {
	constructor(selector = '.tabs') {
		if(document.querySelector(selector)) {
      this.tabs = document.querySelector(selector);
      this.tabsNav = document.querySelector(`[data-tabs="${this.tabs.id}"]`);
      this.tabsItems = this.tabs.querySelectorAll('section');
      this.prepare();
      this.events();
    }else {
      console.log('Aquí no hay tabs uwu')
    }
	}
	prepare() {
		this.tabs.querySelector('.tabs-content').style.width = this.tabsItems.length * 100 + '%';
		this.tabsItems.forEach((item, index) => {
			item.dataset.indexTabItem = index;
			item.style.width = 100 / this.tabsItems.length + '%';
		});
	}
	events() {
		this.tabsNav.addEventListener('click', e => {
			if(e.target.classList.contains('nav-link')) {
				e.preventDefault();
				const targetId = e.target.getAttribute('href');
				const itemTarget = this.tabs.querySelector(targetId);

        this.tabsItems.forEach(t => {
          if(t.classList.contains('tab-active')) {
            t.classList.remove('tab-active')
          }
        })
        itemTarget.classList.add('tab-active');

				this.tabsNav.querySelectorAll('.nav-link').forEach(link => {
					if(link.classList.contains('active')) {
						link.classList.remove('active');
					}
				});
				e.target.classList.add('active');
				this.tabsItems.forEach(item => {
					item.style.left = '-' + itemTarget.dataset.indexTabItem * (100 / this.tabsItems.length) + '%';
				});
			}
		});
	}
}

new Tabs('#tabs');
new Tabs('#auth-tabs');

var acc = document.querySelectorAll(".accordion header");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.maxHeight) {
      panel.style.maxHeight = null;
    } else {
      panel.style.maxHeight = panel.scrollHeight + "px";
    }
  });
}

/**
 * Modal
 */

 class Modal {
  constructor(selector) {
    if(document.querySelector(selector)) {
      this.buttons = Array.from(document.querySelectorAll(`[data-modal = "${selector}"]`));
      this.modal = document.querySelector(selector);
      this.events();
    }
  }
  
  events() {
    
    this.buttons.forEach(button => {
      button.addEventListener('click', e => {
        
        e.preventDefault();
        //console.log(button.getAttribute('href'));
        function actualizarCarritoModal(data){
          let modal = document.querySelector("#modal-cart");
          console.log(modal.children[0].children[1]);
          
          let doc = new DOMParser().parseFromString(data, "text/html");
          console.log(doc.body.children[0].children[0].children[1].children[0]);

          /*modal.innerHTML = "";
          modal.appendChild(doc.body.children[0].children[0].children[0]);*/
          modal.children[0].children[1].innerHTML = '';
          modal.children[0].children[1].appendChild(doc.body.children[0].children[0].children[1].children[0]);
        }
        let formularioServicioData = new FormData();
        formularioServicioData.append("idProducto", button.getAttribute('data-idproducto'));
        formularioServicioData.append("tipoServicio", button.getAttribute('data-tiposervicio'));
        console.log(button.dataset.idproducto);
        fetch("http://localhost:8080/agregarItemCarrito",{
          method: 'POST',
          body: formularioServicioData
        }).then(function(response) {
          return response.text();
        }).then(data => actualizarCarritoModal(data)).catch(function(error) {
          console.log(error);
        });
        
       
        this.modal.classList.add('show');
      });
    });
    this.modal.querySelector('.modal-button-close').addEventListener('click', () => {
      console.log('cerrar');
      this.modal.classList.remove('show');
    });
    this.modal.addEventListener('click', e => {
      if(e.target.classList.contains('modal')) {
        
        this.modal.classList.remove('show');
      }
    })
  }
}

new Modal('#modal-login');
new Modal('#modal-cart');

/**
 * Contador
 */
 document.addEventListener('DOMContentLoaded', () => { 

  //===
  // VARIABLES
  //===
  const DATE_TARGET = new Date('09/30/2022 0:01 AM');
  // DOM for render
  const SPAN_DAYS = document.querySelector('span#days');
  const SPAN_HOURS = document.querySelector('span#hours');
  const SPAN_MINUTES = document.querySelector('span#minutes');
  const SPAN_SECONDS = document.querySelector('span#seconds');
  // Milliseconds for the calculations
  const MILLISECONDS_OF_A_SECOND = 1000;
  const MILLISECONDS_OF_A_MINUTE = MILLISECONDS_OF_A_SECOND * 60;
  const MILLISECONDS_OF_A_HOUR = MILLISECONDS_OF_A_MINUTE * 60;
  const MILLISECONDS_OF_A_DAY = MILLISECONDS_OF_A_HOUR * 24

  //===
  // FUNCTIONS
  //===

  /**
  * Method that updates the countdown and the sample
  */
  function updateCountdown() {
      // Calcs
      const NOW = new Date()
      const DURATION = DATE_TARGET - NOW;
      const REMAINING_DAYS = Math.floor(DURATION / MILLISECONDS_OF_A_DAY);
      const REMAINING_HOURS = Math.floor((DURATION % MILLISECONDS_OF_A_DAY) / MILLISECONDS_OF_A_HOUR);
      const REMAINING_MINUTES = Math.floor((DURATION % MILLISECONDS_OF_A_HOUR) / MILLISECONDS_OF_A_MINUTE);
      const REMAINING_SECONDS = Math.floor((DURATION % MILLISECONDS_OF_A_MINUTE) / MILLISECONDS_OF_A_SECOND);
      // Thanks Pablo Monteserín (https://pablomonteserin.com/cuenta-regresiva/)

      // Render
      SPAN_DAYS.textContent = REMAINING_DAYS;
      SPAN_HOURS.textContent = REMAINING_HOURS;
      SPAN_MINUTES.textContent = REMAINING_MINUTES;
      SPAN_SECONDS.textContent = REMAINING_SECONDS;
  }

  if(SPAN_DAYS) {
    //===
    // INIT
    //===
    updateCountdown();
    // Refresh every second
    setInterval(updateCountdown, MILLISECONDS_OF_A_SECOND);
  }
});