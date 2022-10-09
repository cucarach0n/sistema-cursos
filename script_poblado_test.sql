use escuela;
INSERT INTO `categoria` (`id_categoria`, `act_categoria`, `nom_categoria`) VALUES (NULL, '1', 'Excel');
INSERT INTO `categoria` (`id_categoria`, `act_categoria`, `nom_categoria`) VALUES (NULL, '1', 'Administracion');
INSERT INTO `categoria` (`id_categoria`, `act_categoria`, `nom_categoria`) VALUES (NULL, '1', 'Finanzas');
INSERT INTO `categoria` (`id_categoria`, `act_categoria`, `nom_categoria`) VALUES (NULL, '1', 'Habilidades Blandas');
INSERT INTO `categoria` (`id_categoria`, `act_categoria`, `nom_categoria`) VALUES (NULL, '1', 'Logística');

INSERT INTO `curso` (`id_curso`, `act_curso`, `desc_curso`, `descto_curso`, `dur_curso`, `foto_curso`, `nom_curso`, `prec_curso`, `id_categoria`) VALUES (NULL, '1', '25%', '25', '22', 'https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/BASICO.jpg.webp?itok=f6BeupXy', 'Excel Basico', '250', '1');
INSERT INTO `curso` (`id_curso`, `act_curso`, `desc_curso`, `descto_curso`, `dur_curso`, `foto_curso`, `nom_curso`, `prec_curso`, `id_categoria`) VALUES (NULL, '1', '15%', '15', '25', 'https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/BASICO.jpg.webp?itok=f6BeupXy', 'Excel Intermedio', '250', '1');

INSERT INTO `curso` (`id_curso`, `act_curso`, `desc_curso`, `descto_curso`, `dur_curso`, `foto_curso`, `nom_curso`, `prec_curso`, `id_categoria`) VALUES (NULL, '1', '15%', '15', '25', 'https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/BASICO.jpg.webp?itok=f6BeupXy', 'Curso 1', '250', '2');
INSERT INTO `curso` (`id_curso`, `act_curso`, `desc_curso`, `descto_curso`, `dur_curso`, `foto_curso`, `nom_curso`, `prec_curso`, `id_categoria`) VALUES (NULL, '1', '15%', '15', '25', 'https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/BASICO.jpg.webp?itok=f6BeupXy', 'Curso 2', '250', '2');

insert into programa(act_programa,desc_programa,foto_programa,nom_programa,prec_programa,vigencia_programa) values(1,'Maneja datos y realiza gráficas, genera tablas dinámicas y ejecuta funciones que te permitan analizar datos1...','https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/BASICO.jpg.webp?itok=f6BeupXy','Programa de Especialista en Excel 1',242,4);
insert into programa(act_programa,desc_programa,foto_programa,nom_programa,prec_programa,vigencia_programa) values(1,'Maneja datos y realiza gráficas, genera tablas dinámicas y ejecuta funciones que te permitan analizar datos2...','https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/BASICO.jpg.webp?itok=f6BeupXy','Programa de Especialista en Excel 2',123,1);
insert into programa(act_programa,desc_programa,foto_programa,nom_programa,prec_programa,vigencia_programa) values(1,'Maneja datos y realiza gráficas, genera tablas dinámicas y ejecuta funciones que te permitan analizar datos3...','https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/BASICO.jpg.webp?itok=f6BeupXy','Programa de Especialista en Excel 3',321,2);
insert into programa(act_programa,desc_programa,foto_programa,nom_programa,prec_programa,vigencia_programa) values(1,'Maneja datos y realiza gráficas, genera tablas dinámicas y ejecuta funciones que te permitan analizar datos4...','https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/BASICO.jpg.webp?itok=f6BeupXy','Programa de Especialista en Excel 4',333,5);

insert into programa_curso(act_programa_curso,id_curso,id_programa) values(1,1,1);

insert into membresia(act_membresia,desc_membresia,dscto_membresia,foto_membresia,nom_membresia,prec_membresia,tiempo_membresia,tipo_tiempo_membresia)
values(1,"Con nuestra membresía anual estudia a tu ritmo con acompañamiento docente en nuestra plataforma virtual 24/7.",23,"https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/membresia-anual.jpg.webp?itok=8GEm9X9v","Membresia Anual",250,1,3);/*Dia =1,Mes = 2,Anio = 3*/