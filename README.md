## sorting_service_books

Este App foi desenvolvida para ordenar um array de books utilizando varias condições.
Podemos ordenar por qualquer atributo da classe Book(title, author, edition) de forma ascendente ou descendente.
Utilizamos arquivos xml para carregar os livros que vão ser ordenados e as configuração que definem a ordem 
para o App fazer a ordenação.

## Como utilizar


para instalar:
```


```

Para configurar os arquivos xml:

#### Arquivo de Books

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Books>
	<Book>
		<title>Java How to Program</title>
		<author>Deitel &amp; Deitel</author>
		<edition>2007</edition>
	</Book>
	
	<Book>
		<title>Patterns of Enterprise Application Architecture</title>
		<author>Martin Fowler</author>
		<edition>2002</edition>
	</Book>
	
	<Book>
		<title>Head First Design Patterns</title>
		<author>Elisabeth Freeman</author>
		<edition>2004</edition>
	</Book>
	
	<Book>
		<title>Internet &amp; World Wide Web: How to Program</title>
		<author>Deitel &amp; Deitel</author>
		<edition>2007</edition>
	</Book>
</Books>
```

#### Arquivo de Configuração de ordem para ordenação

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configs>
	<OrderConfig>
		<key>edition</key>
		<value>desc</value>
	</OrderConfig>
	
	<OrderConfig>
		<key>author</key>
		<value>desc</value>
	</OrderConfig>
	
	<OrderConfig>
		<key>title</key>
		<value>asc</value>
	</OrderConfig>
</Configs>
```


### Copyright

Copyright (c) 2014 Douglas Petronilio. See LICENSE.txt for
further details.