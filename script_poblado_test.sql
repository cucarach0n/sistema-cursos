use escuela;
INSERT INTO `categoria` (`id_categoria`, `act_categoria`, `nom_categoria`) VALUES (NULL, '1', 'Excel');
INSERT INTO `categoria` (`id_categoria`, `act_categoria`, `nom_categoria`) VALUES (NULL, '1', 'Administracion');
INSERT INTO `categoria` (`id_categoria`, `act_categoria`, `nom_categoria`) VALUES (NULL, '1', 'Finanzas');
INSERT INTO `categoria` (`id_categoria`, `act_categoria`, `nom_categoria`) VALUES (NULL, '1', 'Habilidades Blandas');
INSERT INTO `categoria` (`id_categoria`, `act_categoria`, `nom_categoria`) VALUES (NULL, '1', 'Logística');

INSERT INTO `curso` (`id_curso`, `act_curso`, `desc_curso`, `descto_curso`, `dur_curso`, `foto_curso`, `nom_curso`, `prec_curso`, `id_categoria`,`cant_materiales_curso`,`horas_curso`,`video_curso`) VALUES (NULL, '1', '25%', '25', '22', 'https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/BASICO.jpg.webp?itok=f6BeupXy', 'Excel Basico', '250', '1',23,43,'https://player.vimeo.com/video/512082463?app_id=122963');
INSERT INTO `curso` (`id_curso`, `act_curso`, `desc_curso`, `descto_curso`, `dur_curso`, `foto_curso`, `nom_curso`, `prec_curso`, `id_categoria`,`cant_materiales_curso`,`horas_curso`,`video_curso`) VALUES (NULL, '1', '15%', '15', '25', 'https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/BASICO.jpg.webp?itok=f6BeupXy', 'Excel Intermedio', '250', '1',34,123,'https://player.vimeo.com/video/512082463?app_id=122963');
INSERT INTO `curso` (`id_curso`, `act_curso`, `desc_curso`, `descto_curso`, `dur_curso`, `foto_curso`, `nom_curso`, `prec_curso`, `id_categoria`,`cant_materiales_curso`,`horas_curso`,`video_curso`) VALUES (NULL, '1', '15%', '15', '25', 'https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/BASICO.jpg.webp?itok=f6BeupXy', 'Curso 1', '250', '2',54,55,'https://player.vimeo.com/video/512082463?app_id=122963');
INSERT INTO `curso` (`id_curso`, `act_curso`, `desc_curso`, `descto_curso`, `dur_curso`, `foto_curso`, `nom_curso`, `prec_curso`, `id_categoria`,`cant_materiales_curso`,`horas_curso`,`video_curso`) VALUES (NULL, '1', '15%', '15', '25', 'https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/BASICO.jpg.webp?itok=f6BeupXy', 'Curso 2', '250', '2',24,34,'https://player.vimeo.com/video/512082463?app_id=122963');

INSERT INTO curso_contenido(act_curso_contenido,desc_curso_contenido,nom_curso_contenido,id_curso,cant_evaluaciones_contenido,cant_materiales_contenido,cant_videos_contenido,horas_contenido) VALUES(1,'Con este curso podrás aplicar las operaciones y funcionalidades básicas de Excel para resolver problemas de cálculo y estadística a través de conocimientos del entorno y funciones de Excel para facilitar las resolución de distinto tipos de tareas.',
                                                                                                                                                                                                        'Funciones de exel',1,23,34,54,21);
INSERT INTO curso_contenido(act_curso_contenido,desc_curso_contenido,nom_curso_contenido,id_curso,cant_evaluaciones_contenido,cant_materiales_contenido,cant_videos_contenido,horas_contenido) VALUES(1,'Con este curso podrás aplicar las operaciones y funcionalidades básicas de Excel para resolver problemas de cálculo y estadística a través de conocimientos del entorno y funciones de Excel para facilitar las resolución de distinto tipos de tareas.',
                                                                                                                                                                                                        'Funciones de exel',2,63,23,44,12);
INSERT INTO curso_contenido(act_curso_contenido,desc_curso_contenido,nom_curso_contenido,id_curso,cant_evaluaciones_contenido,cant_materiales_contenido,cant_videos_contenido,horas_contenido) VALUES(1,'Con este curso podrás aplicar las operaciones y funcionalidades básicas de Excel para resolver problemas de cálculo y estadística a través de conocimientos del entorno y funciones de Excel para facilitar las resolución de distinto tipos de tareas.',
                                                                                                                                                                                                        'Funciones de exel',3,12,22,11,32);
INSERT INTO curso_contenido(act_curso_contenido,desc_curso_contenido,nom_curso_contenido,id_curso,cant_evaluaciones_contenido,cant_materiales_contenido,cant_videos_contenido,horas_contenido) VALUES(1,'Con este curso podrás aplicar las operaciones y funcionalidades básicas de Excel para resolver problemas de cálculo y estadística a través de conocimientos del entorno y funciones de Excel para facilitar las resolución de distinto tipos de tareas.',
                                                                                                                                                                                                        'Funciones de exel',4,43,32,21,43);
INSERT INTO unidad(act_unidad,descripcion_unidad,fecha_creacion_unidad,nombre_unidad,id_curso_contenido) VALUES(1,'en esta unidad aprenderas',now(),'Conociendo Microsoft Excel',1);
INSERT INTO unidad(act_unidad,descripcion_unidad,fecha_creacion_unidad,nombre_unidad,id_curso_contenido) VALUES(1,'en esta unidad aprenderas2',now(),'Conociendo Microsoft Excel2',1);

INSERT INTO unidad(act_unidad,descripcion_unidad,fecha_creacion_unidad,nombre_unidad,id_curso_contenido) VALUES(1,'en esta unidad aprenderas',now(),'Conociendo Microsoft Excel3',2);
INSERT INTO unidad(act_unidad,descripcion_unidad,fecha_creacion_unidad,nombre_unidad,id_curso_contenido) VALUES(1,'en esta unidad aprenderas2',now(),'Conociendo Microsoft Excel4',2);

INSERT INTO unidad(act_unidad,descripcion_unidad,fecha_creacion_unidad,nombre_unidad,id_curso_contenido) VALUES(1,'en esta unidad aprenderas',now(),'Conociendo Microsoft Excel5',3);
INSERT INTO unidad(act_unidad,descripcion_unidad,fecha_creacion_unidad,nombre_unidad,id_curso_contenido) VALUES(1,'en esta unidad aprenderas2',now(),'Conociendo Microsoft Excel6',3);

INSERT INTO unidad(act_unidad,descripcion_unidad,fecha_creacion_unidad,nombre_unidad,id_curso_contenido) VALUES(1,'en esta unidad aprenderas',now(),'Conociendo Microsoft Excel7',4);
INSERT INTO unidad(act_unidad,descripcion_unidad,fecha_creacion_unidad,nombre_unidad,id_curso_contenido) VALUES(1,'en esta unidad aprenderas2',now(),'Conociendo Microsoft Excel8',4);

insert into programa(act_programa,desc_programa,descu_programa,foto_programa,nom_programa,prec_programa,vigencia_programa,video_programa) values(1,'Maneja datos y realiza gráficas, genera tablas dinámicas y ejecuta funciones que te permitan analizar datos1...',25,'https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/BASICO.jpg.webp?itok=f6BeupXy','Programa de Especialista en Excel 1',242,4,'https://player.vimeo.com/video/512082463?app_id=122963');
insert into programa(act_programa,desc_programa,descu_programa,foto_programa,nom_programa,prec_programa,vigencia_programa,video_programa) values(1,'Maneja datos y realiza gráficas, genera tablas dinámicas y ejecuta funciones que te permitan analizar datos2...',23,'https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/BASICO.jpg.webp?itok=f6BeupXy','Programa de Especialista en Excel 2',123,1,'https://player.vimeo.com/video/512082463?app_id=122963');
insert into programa(act_programa,desc_programa,descu_programa,foto_programa,nom_programa,prec_programa,vigencia_programa,video_programa) values(1,'Maneja datos y realiza gráficas, genera tablas dinámicas y ejecuta funciones que te permitan analizar datos3...',54,'https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/BASICO.jpg.webp?itok=f6BeupXy','Programa de Especialista en Excel 3',321,2,'https://player.vimeo.com/video/512082463?app_id=122963');
insert into programa(act_programa,desc_programa,descu_programa,foto_programa,nom_programa,prec_programa,vigencia_programa,video_programa) values(1,'Maneja datos y realiza gráficas, genera tablas dinámicas y ejecuta funciones que te permitan analizar datos4...',14,'https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/BASICO.jpg.webp?itok=f6BeupXy','Programa de Especialista en Excel 4',333,5,'https://player.vimeo.com/video/512082463?app_id=122963');

insert into programa_curso(act_programa_curso,id_curso,id_programa) values(1,1,1);

insert into membresia(act_membresia,desc_membresia,dscto_membresia,foto_membresia,nom_membresia,prec_membresia,tiempo_membresia,tipo_tiempo_membresia)
values(1,"Con nuestra membresía anual estudia a tu ritmo con acompañamiento docente en nuestra plataforma virtual 24/7.",23,"https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/membresia-anual.jpg.webp?itok=8GEm9X9v","Membresia Anual",250,1,3);/*Dia =1,Mes = 2,Anio = 3*/

insert into beneficio(act_beneficio,desc_beneficio,foto_beneficio,nombre_beneficio,id_membresia) values(1,'Podrás contactarte con nuestros docentes a través del chat de consultas disponible las 24 horas y recibir asesoramiento de los Expertos1.','https://www.zegelvirtual.com/sites/default/files/styles/imagemagick/public/beneficios-membresia/asesorias.jpg.webp?itok=aWD174p2','Asesoría Personalizada1',1);
insert into beneficio(act_beneficio,desc_beneficio,foto_beneficio,nombre_beneficio,id_membresia) values(1,'Podrás contactarte con nuestros docentes a través del chat de consultas disponible las 24 horas y recibir asesoramiento de los Expertos2.','https://www.zegelvirtual.com/sites/default/files/styles/imagemagick/public/beneficios-membresia/asesorias.jpg.webp?itok=aWD174p2','Asesoría Personalizada2',1);
insert into beneficio(act_beneficio,desc_beneficio,foto_beneficio,nombre_beneficio,id_membresia) values(1,'Podrás contactarte con nuestros docentes a través del chat de consultas disponible las 24 horas y recibir asesoramiento de los Expertos3.','https://www.zegelvirtual.com/sites/default/files/styles/imagemagick/public/beneficios-membresia/asesorias.jpg.webp?itok=aWD174p2','Asesoría Personalizada3',1);

insert into pregunta(act_programa,pregunta_pregunta,respuesta_pregunta) values(1,'¿Qué necesito para aprobar el curso1?','Debes resolver todas las evaluaciones y tener un promedio mayor a 13 antes de que pasen 30 días de iniciar el curso.1');
insert into pregunta(act_programa,pregunta_pregunta,respuesta_pregunta) values(1,'¿Qué necesito para aprobar el curso2?','Debes resolver todas las evaluaciones y tener un promedio mayor a 13 antes de que pasen 30 días de iniciar el curso.2');
insert into pregunta(act_programa,pregunta_pregunta,respuesta_pregunta) values(1,'¿Qué necesito para aprobar el curso3?','Debes resolver todas las evaluaciones y tener un promedio mayor a 13 antes de que pasen 30 días de iniciar el curso.3');
insert into pregunta(act_programa,pregunta_pregunta,respuesta_pregunta) values(1,'¿Qué necesito para aprobar el curso4?','Debes resolver todas las evaluaciones y tener un promedio mayor a 13 antes de que pasen 30 días de iniciar el curso.4');
insert into pregunta(act_programa,pregunta_pregunta,respuesta_pregunta) values(1,'¿Qué necesito para aprobar el curso5?','Debes resolver todas las evaluaciones y tener un promedio mayor a 13 antes de que pasen 30 días de iniciar el curso.5');
insert into pregunta(act_programa,pregunta_pregunta,respuesta_pregunta) values(1,'¿Qué necesito para aprobar el curso6?','Debes resolver todas las evaluaciones y tener un promedio mayor a 13 antes de que pasen 30 días de iniciar el curso.6');

insert into curso_pregunta(id_curso,id_pregunta) values (1,2);
insert into curso_pregunta(id_curso,id_pregunta) values (1,1);

insert into curso_pregunta(id_curso,id_pregunta) values (2,3);
insert into curso_pregunta(id_curso,id_pregunta) values (2,2);

insert into curso_pregunta(id_curso,id_pregunta) values (3,2);
insert into curso_pregunta(id_curso,id_pregunta) values (3,4);

insert into curso_pregunta(id_curso,id_pregunta) values (4,1);
insert into curso_pregunta(id_curso,id_pregunta) values (4,2);



