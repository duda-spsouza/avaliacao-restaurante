package com.example.demo.model;

	public class Restaurante {
		 
	    private Long restauranteId;
	    private String restauranteNome;
	    private String restauranteEndereco;
	    private String restauranteVoto;
	    private String restauranteDiaSemana;
	 
	    public Restaurante() {
	 
	    }
	 
	    public Restaurante(RestauranteForm restauranteForm) {
	        this.restauranteId = restauranteForm.getRestauranteId();
	        this.restauranteNome = restauranteForm.getRestauranteNome();
	        this.restauranteEndereco = restauranteForm.getRestauranteEndereco();
	        this.restauranteVoto = restauranteForm.getRestauranteVoto();
	        this.restauranteDiaSemana = restauranteForm.getRestauranteDiaSemana();
	    }

		public Restaurante(Long restauranteId, String restauranteNome, String restauranteEndereco,String restauranteVoto, String restauranteDiaSemana) {
			this.restauranteId = restauranteId;
			this.restauranteNome = restauranteNome;
			this.restauranteEndereco = restauranteEndereco;
			this.restauranteVoto = restauranteVoto;
			this.restauranteDiaSemana = restauranteDiaSemana;
		}

		public Long getRestauranteId() {
			return restauranteId;
		}

		public void setRestauranteId(Long restauranteId) {
			this.restauranteId = restauranteId;
		}

		public String getRestauranteNome() {
			return restauranteNome;
		}

		public void setRestauranteNome(String restauranteNome) {
			this.restauranteNome = restauranteNome;
		}

		public String getRestauranteEndereco() {
			return restauranteEndereco;
		}

		public void setRestauranteEndereco(String restauranteEndereco) {
			this.restauranteEndereco = restauranteEndereco;
		}

		public String getRestauranteVoto() {
			return restauranteVoto;
		}

		public void setRestauranteVoto(String restauranteVoto) {
			this.restauranteVoto = restauranteVoto;
		}

		public String getRestauranteDiaSemana() {
			return restauranteDiaSemana;
		}

		public void setRestauranteDiaSemana(String restauranteDiaSemana) {
			this.restauranteDiaSemana = restauranteDiaSemana;
		}
		    	 
	}
