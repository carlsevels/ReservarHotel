#!/bin/bash

ENTITY_NAME=$1

if [ -z "$ENTITY_NAME" ]; then
  echo "❌ Por favor, proporciona un nombre de entidad. Ejemplo: ./generate.sh Reserva"
  exit 1
fi

CAP_NAME="$(tr '[:lower:]' '[:upper:]' <<< ${ENTITY_NAME:0:1})${ENTITY_NAME:1}"
LOW_NAME="$(tr '[:upper:]' '[:lower:]' <<< ${ENTITY_NAME:0:1})${ENTITY_NAME:1}"

BASE_DIR="src/main/java/com/example/demo"

# Crear modelo
cat > $BASE_DIR/models/${CAP_NAME}.java <<EOL
package com.example.demo.models;

import jakarta.persistence.*;

@Entity
public class ${CAP_NAME} {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: Agrega campos aquí

    public ${CAP_NAME}() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // TODO: Agrega getters y setters para otros campos
}
EOL

# Crear DTO
cat > $BASE_DIR/dto/${CAP_NAME}DTO.java <<EOL
package com.example.demo.DTO;

public class ${CAP_NAME}DTO {
    private Long id;

    // TODO: Agrega campos aquí

    public ${CAP_NAME}DTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // TODO: Agrega getters y setters para otros campos
}
EOL

# Crear repositorio
cat > $BASE_DIR/repositories/${CAP_NAME}Repository.java <<EOL
package com.example.demo.repositories;

import com.example.demo.models.${CAP_NAME};
import org.springframework.data.jpa.repository.JpaRepository;

public interface ${CAP_NAME}Repository extends JpaRepository<${CAP_NAME}, Long> {
}
EOL

# Crear servicio
cat > $BASE_DIR/services/${CAP_NAME}Service.java <<EOL
package com.example.demo.services;

import com.example.demo.models.${CAP_NAME};
import com.example.demo.repositories.${CAP_NAME}Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ${CAP_NAME}Service {
    private final ${CAP_NAME}Repository repository;

    public ${CAP_NAME}Service(${CAP_NAME}Repository repository) {
        this.repository = repository;
    }

    public List<${CAP_NAME}> getAll() {
        return repository.findAll();
    }
}
EOL

# Crear controlador
cat > $BASE_DIR/controllers/${CAP_NAME}Controller.java <<EOL
package com.example.demo.controllers;

import com.example.demo.models.${CAP_NAME};
import com.example.demo.services.${CAP_NAME}Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/${LOW_NAME}s")
public class ${CAP_NAME}Controller {
    private final ${CAP_NAME}Service service;

    public ${CAP_NAME}Controller(${CAP_NAME}Service service) {
        this.service = service;
    }

    @GetMapping
    public List<${CAP_NAME}> getAll() {
        return service.getAll();
    }
}
EOL

echo "✅ Clases para '${CAP_NAME}' creadas exitosamente (modelo, DTO, repositorio, servicio, controlador)."
