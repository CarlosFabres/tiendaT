package com.example.tienda.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.tienda.model.Usuario;
import com.example.tienda.repository.UsuarioRepository;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @InjectMocks
    private UsuarioServiceImpl usuarioServicio;

    @Mock
    private UsuarioRepository usuarioRepositoryMock;

    @Test
    public void guardarUsuarioTest() {

        // Creación de un objeto Usuario para utilizar como datos de prueba
        Usuario usuario = new Usuario();
        usuario.setName("Carlos Fabres");

        // Configuración del comportamiento del mock del repositorio para que al llamar a save() devuelva el usuario creado
        when(usuarioRepositoryMock.save(any())).thenReturn(usuario);

        // Llamada al método bajo prueba para crear un usuario
        Usuario resultado = usuarioServicio.createUsuario(usuario);

        // Verificación: Se asegura de que el nombre del usuario creado coincide con el nombre especificado
        assertEquals("Carlos Fabres", resultado.getName());
    }

    @Test
    public void getUsuarioByIdTest() {
        // Datos de prueba: ID y nombre de usuario
        Long userId = 1L;
        Usuario usuario = new Usuario();
        usuario.setId(userId);
        usuario.setName("Carlos Fabres");

        // Configuración del mock del repositorio para que al llamar a findById() con cualquier Long devuelva el usuario creado
        when(usuarioRepositoryMock.findById(anyLong())).thenReturn(Optional.of(usuario));

        // Llamada al método bajo prueba para obtener un usuario por su ID
        Optional<Usuario> resultado = usuarioServicio.getUsuarioById(userId);


        // Verificación: Se asegura de que el nombre del usuario obtenido coincide con el nombre especificado
        assertEquals("Carlos Fabres", resultado.get().getName());
    }
}
