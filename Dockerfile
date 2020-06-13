# Derivando da imagem oficial do MySQL
FROM mysql:8.0.20

# ENV MYSQL_ROOT_PASSWORD root

# ENV MYSQL_DATABASE db_curso

# Adicionando os scripts SQL para serem executados na criação do banco
# COPY ./db/ /docker-entrypoint-initdb.d/

COPY ./prjSpringBoot/src/main/resources/db/ /docker-entrypoint-initdb.d/


# EXPOSE 3306

# CMD /bin/bash