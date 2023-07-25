# Autosync
Faz ftp automático quando um arquivo é criado ou modificado.

Isso é bem útil quando precisa rodar um processo que gera algum tipo de arquivo que deve ser mandado para outro lugar, como um servidor remoto por exemplo.

A configuração é feita no arquivo .env

## Instalação
Crie um arquivo .env na raiz do projeto com o seguinte conteúdo:

```txt
host=host.com.br
port=21
user=usuario
pass=senha
localPath=c:\\xampp\\htdocs\\projeto\\uploads
remotePath=/public_html/uploads/
```
## Referências

https://fullstackdeveloper.guru/2020/12/23/how-to-watch-a-folder-directory-or-changes-using-java/
https://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/ftp/FTPClient.html
https://github.com/cdimascio/dotenv-java
