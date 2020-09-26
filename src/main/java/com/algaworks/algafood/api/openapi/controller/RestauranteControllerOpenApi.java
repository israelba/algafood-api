package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.RestauranteModel;
import com.algaworks.algafood.api.model.input.RestauranteInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Restaurantes")
public interface RestauranteControllerOpenApi {
	
	@ApiOperation("Lista os restaurantes")
	public List<RestauranteModel> listar();
	
	@ApiOperation("Busca um resturante por ID")
	@ApiResponses({
		@ApiResponse(code = 400, message = "ID do resturante inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Resturante não encontrada", response = Problem.class)
	})
	public RestauranteModel buscar(Long restauranteId);

	@ApiOperation("Cadastra um restaurante")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Restaurante cadastrado")
	})
	public RestauranteModel adicionar(
			@ApiParam(name="corpo", value = "Representação de um novo restaurante", required = true)
			RestauranteInput restauranteInput);
	
	@ApiOperation("Atualiza uma cidade por ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Cidade atualizada"),
		@ApiResponse(code = 404, message = "Cidade não encontrada", response = Problem.class)
	})
	public RestauranteModel atualizar(
			@ApiParam(value = "ID de um restaurante", example="1", required = true)
			Long restauranteId,
			
			@ApiParam(name="corpo", value = "Representação de um novo restaurante com novos dados")
			RestauranteInput restauranteInput);
	
	@ApiOperation("Exclui uma restaurante por ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Restaurante excluída"),
		@ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)
	})
	public void remover(
			@ApiParam(value = "ID de um restaurante", example="1", required = true)
			Long restauranteId);
	
	@ApiOperation("Ativa uma restaurante por ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Restaurante ativado com sucesso"),
		@ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)
	})
	public void ativar(
			@ApiParam(value = "ID de um restaurante", example="1", required = true)
			Long restauranteId);
	
	@ApiOperation("Inativa uma restaurante por ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Restaurante inativado com sucesso"),
		@ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)
	})
	public void inativar(
			@ApiParam(value = "ID de um restaurante", example="1", required = true)
			Long restauranteId);
	
	@ApiOperation("Ativa múltiplos restaurantes por ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Restaurante ativados com sucesso"),
	})
	public void ativarMultiplos(
			@ApiParam(name = "corpo", value = "IDs de restaurantes", required = true)
			List<Long> restauranteIds);
	
	@ApiOperation("Inativa múltiplos restaurantes por ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Restaurantes inativados com sucesso"),
	})
	public void inativarMultiplos(
			@ApiParam(name = "corpo", value = "IDs de restaurantes", required = true)
			List<Long> restauranteIds);
	
	@ApiOperation("Abre um restaurante por ID")
		@ApiResponses({
			@ApiResponse(code = 204, message = "Restaurante aberto com sucesso"),
			@ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)
		})
	public void abrir(
			@ApiParam(value = "ID de um restaurante", example = "1", required = true)
			Long restauranteId);
	
	@ApiOperation("Fecha um restaurante por ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Restaurante fechado com sucesso"),
		@ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)
	})
	public void fechar(
			@ApiParam(value = "ID de um restaurante", example = "1", required = true)
			Long restauranteId);

}