PGDMP         7                y            otel    10.10    10.10 m    }           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            ~           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    18667    otel    DATABASE     �   CREATE DATABASE otel WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE otel;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    18691    admin    TABLE     �   CREATE TABLE public.admin (
    id integer NOT NULL,
    isim character varying(80),
    username character varying(80),
    password character varying(100)
);
    DROP TABLE public.admin;
       public         postgres    false    3            �            1259    18689    admin_id_seq    SEQUENCE     �   CREATE SEQUENCE public.admin_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.admin_id_seq;
       public       postgres    false    3    199            �           0    0    admin_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.admin_id_seq OWNED BY public.admin.id;
            public       postgres    false    198            �            1259    18905    cal_res    TABLE     [   CREATE TABLE public.cal_res (
    id integer NOT NULL,
    cid integer,
    rid integer
);
    DROP TABLE public.cal_res;
       public         postgres    false    3            �            1259    18903    cal_res_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cal_res_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.cal_res_id_seq;
       public       postgres    false    221    3            �           0    0    cal_res_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.cal_res_id_seq OWNED BY public.cal_res.id;
            public       postgres    false    220            �            1259    18699    calisan    TABLE     �   CREATE TABLE public.calisan (
    id integer NOT NULL,
    isim character varying(80),
    username character varying(80),
    email character varying(120),
    phone character varying(80),
    password character varying(100)
);
    DROP TABLE public.calisan;
       public         postgres    false    3            �            1259    18697    calisan_id_seq    SEQUENCE     �   CREATE SEQUENCE public.calisan_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.calisan_id_seq;
       public       postgres    false    201    3            �           0    0    calisan_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.calisan_id_seq OWNED BY public.calisan.id;
            public       postgres    false    200            �            1259    18887    etk_uye    TABLE     o   CREATE TABLE public.etk_uye (
    id integer NOT NULL,
    uid integer,
    eid integer,
    toplam integer
);
    DROP TABLE public.etk_uye;
       public         postgres    false    3            �            1259    18885    etk_uye_id_seq    SEQUENCE     �   CREATE SEQUENCE public.etk_uye_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.etk_uye_id_seq;
       public       postgres    false    219    3            �           0    0    etk_uye_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.etk_uye_id_seq OWNED BY public.etk_uye.id;
            public       postgres    false    218            �            1259    18796    etkinlik    TABLE     �   CREATE TABLE public.etkinlik (
    id integer NOT NULL,
    aciklama character varying(60),
    gun character varying(120),
    acma_zaman date,
    kapatma_zaman date,
    fiyat integer
);
    DROP TABLE public.etkinlik;
       public         postgres    false    3            �            1259    18794    etkinlik_id_seq    SEQUENCE     �   CREATE SEQUENCE public.etkinlik_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.etkinlik_id_seq;
       public       postgres    false    209    3            �           0    0    etkinlik_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.etkinlik_id_seq OWNED BY public.etkinlik.id;
            public       postgres    false    208            �            1259    18780    iletisim    TABLE     �   CREATE TABLE public.iletisim (
    id integer NOT NULL,
    isim character varying(60),
    email character varying(120),
    msj character varying(200)
);
    DROP TABLE public.iletisim;
       public         postgres    false    3            �            1259    18778    iletisim_id_seq    SEQUENCE     �   CREATE SEQUENCE public.iletisim_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.iletisim_id_seq;
       public       postgres    false    3    207            �           0    0    iletisim_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.iletisim_id_seq OWNED BY public.iletisim.id;
            public       postgres    false    206            �            1259    18823    kat    TABLE     I   CREATE TABLE public.kat (
    id integer NOT NULL,
    kat_no integer
);
    DROP TABLE public.kat;
       public         postgres    false    3            �            1259    18821 
   kat_id_seq    SEQUENCE     �   CREATE SEQUENCE public.kat_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.kat_id_seq;
       public       postgres    false    211    3            �           0    0 
   kat_id_seq    SEQUENCE OWNED BY     9   ALTER SEQUENCE public.kat_id_seq OWNED BY public.kat.id;
            public       postgres    false    210            �            1259    18831    oda    TABLE     �   CREATE TABLE public.oda (
    id integer NOT NULL,
    oda_no integer,
    isim character varying(80),
    boyut character varying(100),
    fiyat integer,
    oid integer,
    kid integer
);
    DROP TABLE public.oda;
       public         postgres    false    3            �            1259    18867    oda_cal    TABLE     z   CREATE TABLE public.oda_cal (
    id integer NOT NULL,
    oid integer,
    cid integer,
    gun character varying(60)
);
    DROP TABLE public.oda_cal;
       public         postgres    false    3            �            1259    18865    oda_cal_id_seq    SEQUENCE     �   CREATE SEQUENCE public.oda_cal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.oda_cal_id_seq;
       public       postgres    false    217    3            �           0    0    oda_cal_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.oda_cal_id_seq OWNED BY public.oda_cal.id;
            public       postgres    false    216            �            1259    18829 
   oda_id_seq    SEQUENCE     �   CREATE SEQUENCE public.oda_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.oda_id_seq;
       public       postgres    false    213    3            �           0    0 
   oda_id_seq    SEQUENCE OWNED BY     9   ALTER SEQUENCE public.oda_id_seq OWNED BY public.oda.id;
            public       postgres    false    212            �            1259    18670    oda_kategori    TABLE     �   CREATE TABLE public.oda_kategori (
    id integer NOT NULL,
    isim character varying(80),
    tarif character varying(100)
);
     DROP TABLE public.oda_kategori;
       public         postgres    false    3            �            1259    18668    oda_kategori_id_seq    SEQUENCE     �   CREATE SEQUENCE public.oda_kategori_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.oda_kategori_id_seq;
       public       postgres    false    3    197            �           0    0    oda_kategori_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.oda_kategori_id_seq OWNED BY public.oda_kategori.id;
            public       postgres    false    196            �            1259    18725    restoran    TABLE     �   CREATE TABLE public.restoran (
    id integer NOT NULL,
    aciklama character varying(60),
    gun character varying(60),
    acma date,
    kapatma date
);
    DROP TABLE public.restoran;
       public         postgres    false    3            �            1259    18723    restoran_id_seq    SEQUENCE     �   CREATE SEQUENCE public.restoran_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.restoran_id_seq;
       public       postgres    false    203    3            �           0    0    restoran_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.restoran_id_seq OWNED BY public.restoran.id;
            public       postgres    false    202            �            1259    18849    rezervasyon    TABLE     �   CREATE TABLE public.rezervasyon (
    id integer NOT NULL,
    oid integer,
    uid integer,
    fiyat integer,
    alma_zaman date,
    teslim_zaman date
);
    DROP TABLE public.rezervasyon;
       public         postgres    false    3            �            1259    18847    rezervasyon_id_seq    SEQUENCE     �   CREATE SEQUENCE public.rezervasyon_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.rezervasyon_id_seq;
       public       postgres    false    215    3            �           0    0    rezervasyon_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.rezervasyon_id_seq OWNED BY public.rezervasyon.id;
            public       postgres    false    214            �            1259    18751    uye    TABLE       CREATE TABLE public.uye (
    id integer NOT NULL,
    isim character varying(80),
    username character varying(80),
    email character varying(120),
    phone character varying(80),
    password character varying(100),
    address character varying(80)
);
    DROP TABLE public.uye;
       public         postgres    false    3            �            1259    18749 
   uye_id_seq    SEQUENCE     �   CREATE SEQUENCE public.uye_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.uye_id_seq;
       public       postgres    false    205    3            �           0    0 
   uye_id_seq    SEQUENCE OWNED BY     9   ALTER SEQUENCE public.uye_id_seq OWNED BY public.uye.id;
            public       postgres    false    204            �
           2604    18694    admin id    DEFAULT     d   ALTER TABLE ONLY public.admin ALTER COLUMN id SET DEFAULT nextval('public.admin_id_seq'::regclass);
 7   ALTER TABLE public.admin ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    198    199    199            �
           2604    18908 
   cal_res id    DEFAULT     h   ALTER TABLE ONLY public.cal_res ALTER COLUMN id SET DEFAULT nextval('public.cal_res_id_seq'::regclass);
 9   ALTER TABLE public.cal_res ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    221    220    221            �
           2604    18702 
   calisan id    DEFAULT     h   ALTER TABLE ONLY public.calisan ALTER COLUMN id SET DEFAULT nextval('public.calisan_id_seq'::regclass);
 9   ALTER TABLE public.calisan ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    200    201    201            �
           2604    18890 
   etk_uye id    DEFAULT     h   ALTER TABLE ONLY public.etk_uye ALTER COLUMN id SET DEFAULT nextval('public.etk_uye_id_seq'::regclass);
 9   ALTER TABLE public.etk_uye ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    218    219    219            �
           2604    18799    etkinlik id    DEFAULT     j   ALTER TABLE ONLY public.etkinlik ALTER COLUMN id SET DEFAULT nextval('public.etkinlik_id_seq'::regclass);
 :   ALTER TABLE public.etkinlik ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    208    209    209            �
           2604    18783    iletisim id    DEFAULT     j   ALTER TABLE ONLY public.iletisim ALTER COLUMN id SET DEFAULT nextval('public.iletisim_id_seq'::regclass);
 :   ALTER TABLE public.iletisim ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    207    206    207            �
           2604    18826    kat id    DEFAULT     `   ALTER TABLE ONLY public.kat ALTER COLUMN id SET DEFAULT nextval('public.kat_id_seq'::regclass);
 5   ALTER TABLE public.kat ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    211    210    211            �
           2604    18834    oda id    DEFAULT     `   ALTER TABLE ONLY public.oda ALTER COLUMN id SET DEFAULT nextval('public.oda_id_seq'::regclass);
 5   ALTER TABLE public.oda ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    212    213    213            �
           2604    18870 
   oda_cal id    DEFAULT     h   ALTER TABLE ONLY public.oda_cal ALTER COLUMN id SET DEFAULT nextval('public.oda_cal_id_seq'::regclass);
 9   ALTER TABLE public.oda_cal ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    217    216    217            �
           2604    18673    oda_kategori id    DEFAULT     r   ALTER TABLE ONLY public.oda_kategori ALTER COLUMN id SET DEFAULT nextval('public.oda_kategori_id_seq'::regclass);
 >   ALTER TABLE public.oda_kategori ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    197    196    197            �
           2604    18728    restoran id    DEFAULT     j   ALTER TABLE ONLY public.restoran ALTER COLUMN id SET DEFAULT nextval('public.restoran_id_seq'::regclass);
 :   ALTER TABLE public.restoran ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    202    203    203            �
           2604    18852    rezervasyon id    DEFAULT     p   ALTER TABLE ONLY public.rezervasyon ALTER COLUMN id SET DEFAULT nextval('public.rezervasyon_id_seq'::regclass);
 =   ALTER TABLE public.rezervasyon ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    215    214    215            �
           2604    18754    uye id    DEFAULT     `   ALTER TABLE ONLY public.uye ALTER COLUMN id SET DEFAULT nextval('public.uye_id_seq'::regclass);
 5   ALTER TABLE public.uye ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    204    205    205            d          0    18691    admin 
   TABLE DATA               =   COPY public.admin (id, isim, username, password) FROM stdin;
    public       postgres    false    199   �r       z          0    18905    cal_res 
   TABLE DATA               /   COPY public.cal_res (id, cid, rid) FROM stdin;
    public       postgres    false    221   !s       f          0    18699    calisan 
   TABLE DATA               M   COPY public.calisan (id, isim, username, email, phone, password) FROM stdin;
    public       postgres    false    201   >s       x          0    18887    etk_uye 
   TABLE DATA               7   COPY public.etk_uye (id, uid, eid, toplam) FROM stdin;
    public       postgres    false    219   xs       n          0    18796    etkinlik 
   TABLE DATA               W   COPY public.etkinlik (id, aciklama, gun, acma_zaman, kapatma_zaman, fiyat) FROM stdin;
    public       postgres    false    209   �s       l          0    18780    iletisim 
   TABLE DATA               8   COPY public.iletisim (id, isim, email, msj) FROM stdin;
    public       postgres    false    207   �s       p          0    18823    kat 
   TABLE DATA               )   COPY public.kat (id, kat_no) FROM stdin;
    public       postgres    false    211   �s       r          0    18831    oda 
   TABLE DATA               G   COPY public.oda (id, oda_no, isim, boyut, fiyat, oid, kid) FROM stdin;
    public       postgres    false    213   %t       v          0    18867    oda_cal 
   TABLE DATA               4   COPY public.oda_cal (id, oid, cid, gun) FROM stdin;
    public       postgres    false    217   ft       b          0    18670    oda_kategori 
   TABLE DATA               7   COPY public.oda_kategori (id, isim, tarif) FROM stdin;
    public       postgres    false    197   �t       h          0    18725    restoran 
   TABLE DATA               D   COPY public.restoran (id, aciklama, gun, acma, kapatma) FROM stdin;
    public       postgres    false    203   �t       t          0    18849    rezervasyon 
   TABLE DATA               T   COPY public.rezervasyon (id, oid, uid, fiyat, alma_zaman, teslim_zaman) FROM stdin;
    public       postgres    false    215   �t       j          0    18751    uye 
   TABLE DATA               R   COPY public.uye (id, isim, username, email, phone, password, address) FROM stdin;
    public       postgres    false    205   �t       �           0    0    admin_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.admin_id_seq', 1, true);
            public       postgres    false    198            �           0    0    cal_res_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.cal_res_id_seq', 1, false);
            public       postgres    false    220            �           0    0    calisan_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.calisan_id_seq', 1, true);
            public       postgres    false    200            �           0    0    etk_uye_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.etk_uye_id_seq', 1, false);
            public       postgres    false    218            �           0    0    etkinlik_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.etkinlik_id_seq', 1, false);
            public       postgres    false    208            �           0    0    iletisim_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.iletisim_id_seq', 2, true);
            public       postgres    false    206            �           0    0 
   kat_id_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.kat_id_seq', 6, true);
            public       postgres    false    210            �           0    0    oda_cal_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.oda_cal_id_seq', 1, true);
            public       postgres    false    216            �           0    0 
   oda_id_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.oda_id_seq', 3, true);
            public       postgres    false    212            �           0    0    oda_kategori_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.oda_kategori_id_seq', 1, true);
            public       postgres    false    196            �           0    0    restoran_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.restoran_id_seq', 1, false);
            public       postgres    false    202            �           0    0    rezervasyon_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.rezervasyon_id_seq', 1, false);
            public       postgres    false    214            �           0    0 
   uye_id_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('public.uye_id_seq', 1, true);
            public       postgres    false    204            �
           2606    18696    admin admin_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.admin DROP CONSTRAINT admin_pkey;
       public         postgres    false    199            �
           2606    18910    cal_res cal_res_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cal_res
    ADD CONSTRAINT cal_res_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cal_res DROP CONSTRAINT cal_res_pkey;
       public         postgres    false    221            �
           2606    18704    calisan calisan_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.calisan
    ADD CONSTRAINT calisan_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.calisan DROP CONSTRAINT calisan_pkey;
       public         postgres    false    201            �
           2606    18892    etk_uye etk_uye_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.etk_uye
    ADD CONSTRAINT etk_uye_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.etk_uye DROP CONSTRAINT etk_uye_pkey;
       public         postgres    false    219            �
           2606    18801    etkinlik etkinlik_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.etkinlik
    ADD CONSTRAINT etkinlik_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.etkinlik DROP CONSTRAINT etkinlik_pkey;
       public         postgres    false    209            �
           2606    18785    iletisim iletisim_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.iletisim
    ADD CONSTRAINT iletisim_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.iletisim DROP CONSTRAINT iletisim_pkey;
       public         postgres    false    207            �
           2606    18828    kat kat_pkey 
   CONSTRAINT     J   ALTER TABLE ONLY public.kat
    ADD CONSTRAINT kat_pkey PRIMARY KEY (id);
 6   ALTER TABLE ONLY public.kat DROP CONSTRAINT kat_pkey;
       public         postgres    false    211            �
           2606    18872    oda_cal oda_cal_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.oda_cal
    ADD CONSTRAINT oda_cal_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.oda_cal DROP CONSTRAINT oda_cal_pkey;
       public         postgres    false    217            �
           2606    18675    oda_kategori oda_kategori_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.oda_kategori
    ADD CONSTRAINT oda_kategori_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.oda_kategori DROP CONSTRAINT oda_kategori_pkey;
       public         postgres    false    197            �
           2606    18836    oda oda_pkey 
   CONSTRAINT     J   ALTER TABLE ONLY public.oda
    ADD CONSTRAINT oda_pkey PRIMARY KEY (id);
 6   ALTER TABLE ONLY public.oda DROP CONSTRAINT oda_pkey;
       public         postgres    false    213            �
           2606    18730    restoran restoran_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.restoran
    ADD CONSTRAINT restoran_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.restoran DROP CONSTRAINT restoran_pkey;
       public         postgres    false    203            �
           2606    18854    rezervasyon rezervasyon_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.rezervasyon
    ADD CONSTRAINT rezervasyon_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.rezervasyon DROP CONSTRAINT rezervasyon_pkey;
       public         postgres    false    215            �
           2606    18759    uye uye_pkey 
   CONSTRAINT     J   ALTER TABLE ONLY public.uye
    ADD CONSTRAINT uye_pkey PRIMARY KEY (id);
 6   ALTER TABLE ONLY public.uye DROP CONSTRAINT uye_pkey;
       public         postgres    false    205            �
           2606    18911    cal_res cal_res_cid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.cal_res
    ADD CONSTRAINT cal_res_cid_fkey FOREIGN KEY (cid) REFERENCES public.calisan(id) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY public.cal_res DROP CONSTRAINT cal_res_cid_fkey;
       public       postgres    false    201    2761    221            �
           2606    18916    cal_res cal_res_rid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.cal_res
    ADD CONSTRAINT cal_res_rid_fkey FOREIGN KEY (rid) REFERENCES public.restoran(id) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY public.cal_res DROP CONSTRAINT cal_res_rid_fkey;
       public       postgres    false    203    2763    221            �
           2606    18898    etk_uye etk_uye_eid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.etk_uye
    ADD CONSTRAINT etk_uye_eid_fkey FOREIGN KEY (eid) REFERENCES public.etkinlik(id) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY public.etk_uye DROP CONSTRAINT etk_uye_eid_fkey;
       public       postgres    false    209    2769    219            �
           2606    18893    etk_uye etk_uye_uid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.etk_uye
    ADD CONSTRAINT etk_uye_uid_fkey FOREIGN KEY (uid) REFERENCES public.uye(id) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY public.etk_uye DROP CONSTRAINT etk_uye_uid_fkey;
       public       postgres    false    205    219    2765            �
           2606    18878    oda_cal oda_cal_cid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.oda_cal
    ADD CONSTRAINT oda_cal_cid_fkey FOREIGN KEY (cid) REFERENCES public.calisan(id) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY public.oda_cal DROP CONSTRAINT oda_cal_cid_fkey;
       public       postgres    false    2761    217    201            �
           2606    18873    oda_cal oda_cal_oid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.oda_cal
    ADD CONSTRAINT oda_cal_oid_fkey FOREIGN KEY (oid) REFERENCES public.oda(id) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY public.oda_cal DROP CONSTRAINT oda_cal_oid_fkey;
       public       postgres    false    2773    213    217            �
           2606    18842    oda oda_kid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.oda
    ADD CONSTRAINT oda_kid_fkey FOREIGN KEY (kid) REFERENCES public.kat(id) ON UPDATE CASCADE ON DELETE CASCADE;
 :   ALTER TABLE ONLY public.oda DROP CONSTRAINT oda_kid_fkey;
       public       postgres    false    2771    211    213            �
           2606    18837    oda oda_oid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.oda
    ADD CONSTRAINT oda_oid_fkey FOREIGN KEY (oid) REFERENCES public.oda_kategori(id) ON UPDATE CASCADE ON DELETE CASCADE;
 :   ALTER TABLE ONLY public.oda DROP CONSTRAINT oda_oid_fkey;
       public       postgres    false    197    2757    213            �
           2606    18855     rezervasyon rezervasyon_oid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.rezervasyon
    ADD CONSTRAINT rezervasyon_oid_fkey FOREIGN KEY (oid) REFERENCES public.oda(id) ON UPDATE CASCADE ON DELETE CASCADE;
 J   ALTER TABLE ONLY public.rezervasyon DROP CONSTRAINT rezervasyon_oid_fkey;
       public       postgres    false    215    2773    213            �
           2606    18860     rezervasyon rezervasyon_uid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.rezervasyon
    ADD CONSTRAINT rezervasyon_uid_fkey FOREIGN KEY (uid) REFERENCES public.uye(id) ON UPDATE CASCADE ON DELETE CASCADE;
 J   ALTER TABLE ONLY public.rezervasyon DROP CONSTRAINT rezervasyon_uid_fkey;
       public       postgres    false    205    215    2765            d      x�3�,J,�H���F�\1z\\\ O��      z      x������ � �      f   *   x�3�LN�����<�D�r��<NC#cS3N ����� Ͽ	.      x      x������ � �      n      x������ � �      l   .   x�3�N,J�,�z�y���\F�E������� ����� �      p   %   x�3�4�2�4�2�4�2�4�2�4�2�4����� 5Q�      r   1   x�3�4�440�410�bN#SNCNC.cNc�8��1����qqq ԁ�      v      x�3���4�,N,)-JI������ <GG      b       x�3�t��I�t+��QpIM�)������� X�      h      x������ � �      t      x������ � �      j   '   x�3�,�L�`�r��<NC#cS3N ������� �#�     