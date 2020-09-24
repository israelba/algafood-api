package com.algaworks.algafood.api.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.controller.UsuarioController;
import com.algaworks.algafood.api.model.UsuarioModel;
import com.algaworks.algafood.domain.model.Usuario;

@Component
public class UsuarioModelAssembler extends RepresentationModelAssemblerSupport<Usuario, UsuarioModel> {

	@Autowired
	private ModelMapper modelMapper;
	
	public UsuarioModelAssembler() {
		super(UsuarioController.class, UsuarioModel.class);
	}

	@Override
	public UsuarioModel toModel(Usuario usuario) {
		UsuarioModel usuarioModel = createModelWithId(usuario.getId(), usuario);
		
		modelMapper.map(usuario, usuarioModel);
		
		usuarioModel.add(linkTo(methodOn(UsuarioController.class)
				.listar()).withRel("usuarios"));
		
		return usuarioModel;
	}
	
	@Override
	public CollectionModel<UsuarioModel> toCollectionModel(Iterable<? extends Usuario> usuarios) {
		return super.toCollectionModel(usuarios)
				.add(linkTo(UsuarioController.class).withSelfRel());
	}
}

//@Component
//public class UsuarioModelAssembler extends DomainAssembler2<Usuario, UsuarioModel> {
//
//	public UsuarioModelAssembler() {
//		super(UsuarioController.class, UsuarioModel.class);
//	}
//
//	@Override
//	protected Object getId(Usuario entity) {
//		return entity.getId();
//	}
//	
//	@Override
//	public void modifyModel(RepresentationModel<UsuarioModel> usuarioModel) {
//		usuarioModel.add(linkTo(methodOn(UsuarioController.class)
//				.listar()).withRel("usuarios"));
//
//	}
//
//	@Override
//	protected void modifyCollectionModel(CollectionModel<UsuarioModel> collectionModel) {
//		collectionModel.add(linkTo(UsuarioController.class).withSelfRel());
//	}
//}
