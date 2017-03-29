CREATE TABLE `pizza` (
  `id` int(11) auto_increment NOT NULL,
  `categorie`  varchar(20) NOT NULL,
  `reference` varchar(10) NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `prix` double DEFAULT NULL,
  `url_image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `pizza` (`id`, `categorie`, `reference`, `libelle`, `prix`, `url_image`) VALUES
(1, 'Viande', 'TOT', 'toto', 45, NULL);