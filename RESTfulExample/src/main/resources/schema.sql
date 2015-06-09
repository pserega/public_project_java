CREATE TABLE mp_tree (id INT , name VARCHAR(50),pathTree VARCHAR(100));
CREATE TABLE payment (pathTree VARCHAR(100) , id VARCHAR(50),service VARCHAR(50),name VARCHAR(50),date VARCHAR(50),account VARCHAR(50),comment VARCHAR(50),status VARCHAR(50));
CREATE TABLE tb_sum (pathTree VARCHAR(100),fin VARCHAR(50) , fout VARCHAR(50),commission VARCHAR(50));