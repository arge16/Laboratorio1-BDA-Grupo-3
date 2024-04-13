PGDMP                      |            lab1TBD    16.2    16.2 U    n           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            o           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            p           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            q           1262    17862    lab1TBD    DATABASE     k   CREATE DATABASE "lab1TBD" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
    DROP DATABASE "lab1TBD";
                postgres    false            �            1259    18826    eme_habilidad    TABLE     �   CREATE TABLE public.eme_habilidad (
    id_eme_habilidad integer NOT NULL,
    id_emergencia bigint,
    id_habilidad bigint
);
 !   DROP TABLE public.eme_habilidad;
       public         heap    postgres    false            �            1259    18825 "   eme_habilidad_id_eme_habilidad_seq    SEQUENCE     �   CREATE SEQUENCE public.eme_habilidad_id_eme_habilidad_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.eme_habilidad_id_eme_habilidad_seq;
       public          postgres    false    234            r           0    0 "   eme_habilidad_id_eme_habilidad_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public.eme_habilidad_id_eme_habilidad_seq OWNED BY public.eme_habilidad.id_eme_habilidad;
          public          postgres    false    233            �            1259    18817 
   emergencia    TABLE     �   CREATE TABLE public.emergencia (
    id_emergencia integer NOT NULL,
    nombre character varying,
    descripcion character varying,
    fecha_inicio date,
    fecha_fin date,
    id_institucion bigint
);
    DROP TABLE public.emergencia;
       public         heap    postgres    false            �            1259    18816    emergencia_id_emergencia_seq    SEQUENCE     �   CREATE SEQUENCE public.emergencia_id_emergencia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.emergencia_id_emergencia_seq;
       public          postgres    false    232            s           0    0    emergencia_id_emergencia_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.emergencia_id_emergencia_seq OWNED BY public.emergencia.id_emergencia;
          public          postgres    false    231            �            1259    18808    estado_tarea    TABLE     �   CREATE TABLE public.estado_tarea (
    id_estado_tarea integer NOT NULL,
    descripcion character varying,
    id_tarea bigint
);
     DROP TABLE public.estado_tarea;
       public         heap    postgres    false            �            1259    18807     estado_tarea_id_estado_tarea_seq    SEQUENCE     �   CREATE SEQUENCE public.estado_tarea_id_estado_tarea_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.estado_tarea_id_estado_tarea_seq;
       public          postgres    false    230            t           0    0     estado_tarea_id_estado_tarea_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.estado_tarea_id_estado_tarea_seq OWNED BY public.estado_tarea.id_estado_tarea;
          public          postgres    false    229            �            1259    18799 	   habilidad    TABLE     �   CREATE TABLE public.habilidad (
    id_habilidad integer NOT NULL,
    nombre character varying,
    descripcion character varying,
    certificacion_requerida integer
);
    DROP TABLE public.habilidad;
       public         heap    postgres    false            �            1259    18798    habilidad_id_habilidad_seq    SEQUENCE     �   CREATE SEQUENCE public.habilidad_id_habilidad_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.habilidad_id_habilidad_seq;
       public          postgres    false    228            u           0    0    habilidad_id_habilidad_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.habilidad_id_habilidad_seq OWNED BY public.habilidad.id_habilidad;
          public          postgres    false    227            �            1259    18790    institucion    TABLE     �   CREATE TABLE public.institucion (
    id_institucion integer NOT NULL,
    nombre character varying,
    email character varying,
    telefono character varying,
    ubicacion character varying
);
    DROP TABLE public.institucion;
       public         heap    postgres    false            �            1259    18789    institucion_id_institucion_seq    SEQUENCE     �   CREATE SEQUENCE public.institucion_id_institucion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.institucion_id_institucion_seq;
       public          postgres    false    226            v           0    0    institucion_id_institucion_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.institucion_id_institucion_seq OWNED BY public.institucion.id_institucion;
          public          postgres    false    225            �            1259    18783    ranking    TABLE     �   CREATE TABLE public.ranking (
    id_ranking integer NOT NULL,
    id_voluntario bigint,
    id_tarea bigint,
    puntuacion integer
);
    DROP TABLE public.ranking;
       public         heap    postgres    false            �            1259    18782    ranking_id_ranking_seq    SEQUENCE     �   CREATE SEQUENCE public.ranking_id_ranking_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.ranking_id_ranking_seq;
       public          postgres    false    224            w           0    0    ranking_id_ranking_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.ranking_id_ranking_seq OWNED BY public.ranking.id_ranking;
          public          postgres    false    223            �            1259    18767    tarea    TABLE     �   CREATE TABLE public.tarea (
    id_tarea integer NOT NULL,
    descripcion character varying,
    id_emergencia bigint,
    id_voluntario bigint,
    completada integer
);
    DROP TABLE public.tarea;
       public         heap    postgres    false            �            1259    18776    tarea_habilidad    TABLE        CREATE TABLE public.tarea_habilidad (
    id_tarea_habilidad integer NOT NULL,
    id_tarea bigint,
    id_habilidad bigint
);
 #   DROP TABLE public.tarea_habilidad;
       public         heap    postgres    false            �            1259    18775 &   tarea_habilidad_id_tarea_habilidad_seq    SEQUENCE     �   CREATE SEQUENCE public.tarea_habilidad_id_tarea_habilidad_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public.tarea_habilidad_id_tarea_habilidad_seq;
       public          postgres    false    222            x           0    0 &   tarea_habilidad_id_tarea_habilidad_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public.tarea_habilidad_id_tarea_habilidad_seq OWNED BY public.tarea_habilidad.id_tarea_habilidad;
          public          postgres    false    221            �            1259    18766    tarea_id_tarea_seq    SEQUENCE     �   CREATE SEQUENCE public.tarea_id_tarea_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.tarea_id_tarea_seq;
       public          postgres    false    220            y           0    0    tarea_id_tarea_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.tarea_id_tarea_seq OWNED BY public.tarea.id_tarea;
          public          postgres    false    219            �            1259    18760    vol_habilidad    TABLE     �   CREATE TABLE public.vol_habilidad (
    id_vol_habilidad integer NOT NULL,
    id_voluntario bigint,
    id_habilidad bigint,
    nivel_proficiencia integer
);
 !   DROP TABLE public.vol_habilidad;
       public         heap    postgres    false            �            1259    18759 "   vol_habilidad_id_vol_habilidad_seq    SEQUENCE     �   CREATE SEQUENCE public.vol_habilidad_id_vol_habilidad_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.vol_habilidad_id_vol_habilidad_seq;
       public          postgres    false    218            z           0    0 "   vol_habilidad_id_vol_habilidad_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public.vol_habilidad_id_vol_habilidad_seq OWNED BY public.vol_habilidad.id_vol_habilidad;
          public          postgres    false    217            �            1259    18751 
   voluntario    TABLE     �   CREATE TABLE public.voluntario (
    id_voluntario integer NOT NULL,
    nombre character varying,
    edad integer,
    direccion character varying,
    genero character varying,
    email character varying,
    telefono character varying
);
    DROP TABLE public.voluntario;
       public         heap    postgres    false            �            1259    18750    voluntario_id_voluntario_seq    SEQUENCE     �   CREATE SEQUENCE public.voluntario_id_voluntario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.voluntario_id_voluntario_seq;
       public          postgres    false    216            {           0    0    voluntario_id_voluntario_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.voluntario_id_voluntario_seq OWNED BY public.voluntario.id_voluntario;
          public          postgres    false    215            �           2604    18829    eme_habilidad id_eme_habilidad    DEFAULT     �   ALTER TABLE ONLY public.eme_habilidad ALTER COLUMN id_eme_habilidad SET DEFAULT nextval('public.eme_habilidad_id_eme_habilidad_seq'::regclass);
 M   ALTER TABLE public.eme_habilidad ALTER COLUMN id_eme_habilidad DROP DEFAULT;
       public          postgres    false    233    234    234            �           2604    18820    emergencia id_emergencia    DEFAULT     �   ALTER TABLE ONLY public.emergencia ALTER COLUMN id_emergencia SET DEFAULT nextval('public.emergencia_id_emergencia_seq'::regclass);
 G   ALTER TABLE public.emergencia ALTER COLUMN id_emergencia DROP DEFAULT;
       public          postgres    false    232    231    232            �           2604    18811    estado_tarea id_estado_tarea    DEFAULT     �   ALTER TABLE ONLY public.estado_tarea ALTER COLUMN id_estado_tarea SET DEFAULT nextval('public.estado_tarea_id_estado_tarea_seq'::regclass);
 K   ALTER TABLE public.estado_tarea ALTER COLUMN id_estado_tarea DROP DEFAULT;
       public          postgres    false    229    230    230            �           2604    18802    habilidad id_habilidad    DEFAULT     �   ALTER TABLE ONLY public.habilidad ALTER COLUMN id_habilidad SET DEFAULT nextval('public.habilidad_id_habilidad_seq'::regclass);
 E   ALTER TABLE public.habilidad ALTER COLUMN id_habilidad DROP DEFAULT;
       public          postgres    false    228    227    228            �           2604    18793    institucion id_institucion    DEFAULT     �   ALTER TABLE ONLY public.institucion ALTER COLUMN id_institucion SET DEFAULT nextval('public.institucion_id_institucion_seq'::regclass);
 I   ALTER TABLE public.institucion ALTER COLUMN id_institucion DROP DEFAULT;
       public          postgres    false    225    226    226            �           2604    18786    ranking id_ranking    DEFAULT     x   ALTER TABLE ONLY public.ranking ALTER COLUMN id_ranking SET DEFAULT nextval('public.ranking_id_ranking_seq'::regclass);
 A   ALTER TABLE public.ranking ALTER COLUMN id_ranking DROP DEFAULT;
       public          postgres    false    223    224    224            �           2604    18770    tarea id_tarea    DEFAULT     p   ALTER TABLE ONLY public.tarea ALTER COLUMN id_tarea SET DEFAULT nextval('public.tarea_id_tarea_seq'::regclass);
 =   ALTER TABLE public.tarea ALTER COLUMN id_tarea DROP DEFAULT;
       public          postgres    false    220    219    220            �           2604    18779 "   tarea_habilidad id_tarea_habilidad    DEFAULT     �   ALTER TABLE ONLY public.tarea_habilidad ALTER COLUMN id_tarea_habilidad SET DEFAULT nextval('public.tarea_habilidad_id_tarea_habilidad_seq'::regclass);
 Q   ALTER TABLE public.tarea_habilidad ALTER COLUMN id_tarea_habilidad DROP DEFAULT;
       public          postgres    false    221    222    222            �           2604    18763    vol_habilidad id_vol_habilidad    DEFAULT     �   ALTER TABLE ONLY public.vol_habilidad ALTER COLUMN id_vol_habilidad SET DEFAULT nextval('public.vol_habilidad_id_vol_habilidad_seq'::regclass);
 M   ALTER TABLE public.vol_habilidad ALTER COLUMN id_vol_habilidad DROP DEFAULT;
       public          postgres    false    217    218    218            �           2604    18754    voluntario id_voluntario    DEFAULT     �   ALTER TABLE ONLY public.voluntario ALTER COLUMN id_voluntario SET DEFAULT nextval('public.voluntario_id_voluntario_seq'::regclass);
 G   ALTER TABLE public.voluntario ALTER COLUMN id_voluntario DROP DEFAULT;
       public          postgres    false    216    215    216            k          0    18826    eme_habilidad 
   TABLE DATA           V   COPY public.eme_habilidad (id_eme_habilidad, id_emergencia, id_habilidad) FROM stdin;
    public          postgres    false    234   i       i          0    18817 
   emergencia 
   TABLE DATA           q   COPY public.emergencia (id_emergencia, nombre, descripcion, fecha_inicio, fecha_fin, id_institucion) FROM stdin;
    public          postgres    false    232   7i       g          0    18808    estado_tarea 
   TABLE DATA           N   COPY public.estado_tarea (id_estado_tarea, descripcion, id_tarea) FROM stdin;
    public          postgres    false    230   �i       e          0    18799 	   habilidad 
   TABLE DATA           _   COPY public.habilidad (id_habilidad, nombre, descripcion, certificacion_requerida) FROM stdin;
    public          postgres    false    228   �i       c          0    18790    institucion 
   TABLE DATA           Y   COPY public.institucion (id_institucion, nombre, email, telefono, ubicacion) FROM stdin;
    public          postgres    false    226   #j       a          0    18783    ranking 
   TABLE DATA           R   COPY public.ranking (id_ranking, id_voluntario, id_tarea, puntuacion) FROM stdin;
    public          postgres    false    224   uj       ]          0    18767    tarea 
   TABLE DATA           `   COPY public.tarea (id_tarea, descripcion, id_emergencia, id_voluntario, completada) FROM stdin;
    public          postgres    false    220   �j       _          0    18776    tarea_habilidad 
   TABLE DATA           U   COPY public.tarea_habilidad (id_tarea_habilidad, id_tarea, id_habilidad) FROM stdin;
    public          postgres    false    222   k       [          0    18760    vol_habilidad 
   TABLE DATA           j   COPY public.vol_habilidad (id_vol_habilidad, id_voluntario, id_habilidad, nivel_proficiencia) FROM stdin;
    public          postgres    false    218   /k       Y          0    18751 
   voluntario 
   TABLE DATA           e   COPY public.voluntario (id_voluntario, nombre, edad, direccion, genero, email, telefono) FROM stdin;
    public          postgres    false    216   Sk       |           0    0 "   eme_habilidad_id_eme_habilidad_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.eme_habilidad_id_eme_habilidad_seq', 4, true);
          public          postgres    false    233            }           0    0    emergencia_id_emergencia_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.emergencia_id_emergencia_seq', 5, true);
          public          postgres    false    231            ~           0    0     estado_tarea_id_estado_tarea_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.estado_tarea_id_estado_tarea_seq', 8, true);
          public          postgres    false    229                       0    0    habilidad_id_habilidad_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.habilidad_id_habilidad_seq', 3, true);
          public          postgres    false    227            �           0    0    institucion_id_institucion_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.institucion_id_institucion_seq', 3, true);
          public          postgres    false    225            �           0    0    ranking_id_ranking_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.ranking_id_ranking_seq', 10, true);
          public          postgres    false    223            �           0    0 &   tarea_habilidad_id_tarea_habilidad_seq    SEQUENCE SET     T   SELECT pg_catalog.setval('public.tarea_habilidad_id_tarea_habilidad_seq', 6, true);
          public          postgres    false    221            �           0    0    tarea_id_tarea_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.tarea_id_tarea_seq', 4, true);
          public          postgres    false    219            �           0    0 "   vol_habilidad_id_vol_habilidad_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.vol_habilidad_id_vol_habilidad_seq', 2, true);
          public          postgres    false    217            �           0    0    voluntario_id_voluntario_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.voluntario_id_voluntario_seq', 6, true);
          public          postgres    false    215            �           2606    18831     eme_habilidad eme_habilidad_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT eme_habilidad_pkey PRIMARY KEY (id_eme_habilidad);
 J   ALTER TABLE ONLY public.eme_habilidad DROP CONSTRAINT eme_habilidad_pkey;
       public            postgres    false    234            �           2606    18824    emergencia emergencia_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.emergencia
    ADD CONSTRAINT emergencia_pkey PRIMARY KEY (id_emergencia);
 D   ALTER TABLE ONLY public.emergencia DROP CONSTRAINT emergencia_pkey;
       public            postgres    false    232            �           2606    18815    estado_tarea estado_tarea_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.estado_tarea
    ADD CONSTRAINT estado_tarea_pkey PRIMARY KEY (id_estado_tarea);
 H   ALTER TABLE ONLY public.estado_tarea DROP CONSTRAINT estado_tarea_pkey;
       public            postgres    false    230            �           2606    18806    habilidad habilidad_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.habilidad
    ADD CONSTRAINT habilidad_pkey PRIMARY KEY (id_habilidad);
 B   ALTER TABLE ONLY public.habilidad DROP CONSTRAINT habilidad_pkey;
       public            postgres    false    228            �           2606    18797    institucion institucion_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.institucion
    ADD CONSTRAINT institucion_pkey PRIMARY KEY (id_institucion);
 F   ALTER TABLE ONLY public.institucion DROP CONSTRAINT institucion_pkey;
       public            postgres    false    226            �           2606    18788    ranking ranking_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.ranking
    ADD CONSTRAINT ranking_pkey PRIMARY KEY (id_ranking);
 >   ALTER TABLE ONLY public.ranking DROP CONSTRAINT ranking_pkey;
       public            postgres    false    224            �           2606    18781 $   tarea_habilidad tarea_habilidad_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public.tarea_habilidad
    ADD CONSTRAINT tarea_habilidad_pkey PRIMARY KEY (id_tarea_habilidad);
 N   ALTER TABLE ONLY public.tarea_habilidad DROP CONSTRAINT tarea_habilidad_pkey;
       public            postgres    false    222            �           2606    18774    tarea tarea_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.tarea
    ADD CONSTRAINT tarea_pkey PRIMARY KEY (id_tarea);
 :   ALTER TABLE ONLY public.tarea DROP CONSTRAINT tarea_pkey;
       public            postgres    false    220            �           2606    18765     vol_habilidad vol_habilidad_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.vol_habilidad
    ADD CONSTRAINT vol_habilidad_pkey PRIMARY KEY (id_vol_habilidad);
 J   ALTER TABLE ONLY public.vol_habilidad DROP CONSTRAINT vol_habilidad_pkey;
       public            postgres    false    218            �           2606    18758    voluntario voluntario_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.voluntario
    ADD CONSTRAINT voluntario_pkey PRIMARY KEY (id_voluntario);
 D   ALTER TABLE ONLY public.voluntario DROP CONSTRAINT voluntario_pkey;
       public            postgres    false    216            �           2606    18857 .   eme_habilidad eme_habilidad_id_emergencia_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT eme_habilidad_id_emergencia_fkey FOREIGN KEY (id_emergencia) REFERENCES public.emergencia(id_emergencia);
 X   ALTER TABLE ONLY public.eme_habilidad DROP CONSTRAINT eme_habilidad_id_emergencia_fkey;
       public          postgres    false    234    232    3515            �           2606    18852 -   eme_habilidad eme_habilidad_id_habilidad_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.eme_habilidad
    ADD CONSTRAINT eme_habilidad_id_habilidad_fkey FOREIGN KEY (id_habilidad) REFERENCES public.habilidad(id_habilidad);
 W   ALTER TABLE ONLY public.eme_habilidad DROP CONSTRAINT eme_habilidad_id_habilidad_fkey;
       public          postgres    false    3511    234    228            �           2606    18877 )   emergencia emergencia_id_institucion_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.emergencia
    ADD CONSTRAINT emergencia_id_institucion_fkey FOREIGN KEY (id_institucion) REFERENCES public.institucion(id_institucion);
 S   ALTER TABLE ONLY public.emergencia DROP CONSTRAINT emergencia_id_institucion_fkey;
       public          postgres    false    232    3509    226            �           2606    18837    ranking ranking_id_tarea_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ranking
    ADD CONSTRAINT ranking_id_tarea_fkey FOREIGN KEY (id_tarea) REFERENCES public.tarea(id_tarea);
 G   ALTER TABLE ONLY public.ranking DROP CONSTRAINT ranking_id_tarea_fkey;
       public          postgres    false    3503    224    220            �           2606    18832 "   ranking ranking_id_voluntario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ranking
    ADD CONSTRAINT ranking_id_voluntario_fkey FOREIGN KEY (id_voluntario) REFERENCES public.voluntario(id_voluntario);
 L   ALTER TABLE ONLY public.ranking DROP CONSTRAINT ranking_id_voluntario_fkey;
       public          postgres    false    216    224    3499            �           2606    18867 1   tarea_habilidad tarea_habilidad_id_habilidad_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tarea_habilidad
    ADD CONSTRAINT tarea_habilidad_id_habilidad_fkey FOREIGN KEY (id_habilidad) REFERENCES public.habilidad(id_habilidad);
 [   ALTER TABLE ONLY public.tarea_habilidad DROP CONSTRAINT tarea_habilidad_id_habilidad_fkey;
       public          postgres    false    3511    228    222            �           2606    18862 -   tarea_habilidad tarea_habilidad_id_tarea_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tarea_habilidad
    ADD CONSTRAINT tarea_habilidad_id_tarea_fkey FOREIGN KEY (id_tarea) REFERENCES public.tarea(id_tarea);
 W   ALTER TABLE ONLY public.tarea_habilidad DROP CONSTRAINT tarea_habilidad_id_tarea_fkey;
       public          postgres    false    222    3503    220            �           2606    18882    tarea tarea_id_emergencia_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tarea
    ADD CONSTRAINT tarea_id_emergencia_fkey FOREIGN KEY (id_emergencia) REFERENCES public.emergencia(id_emergencia);
 H   ALTER TABLE ONLY public.tarea DROP CONSTRAINT tarea_id_emergencia_fkey;
       public          postgres    false    232    3515    220            �           2606    18872    tarea tarea_id_tarea_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tarea
    ADD CONSTRAINT tarea_id_tarea_fkey FOREIGN KEY (id_tarea) REFERENCES public.estado_tarea(id_estado_tarea);
 C   ALTER TABLE ONLY public.tarea DROP CONSTRAINT tarea_id_tarea_fkey;
       public          postgres    false    220    3513    230            �           2606    18847 -   vol_habilidad vol_habilidad_id_habilidad_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.vol_habilidad
    ADD CONSTRAINT vol_habilidad_id_habilidad_fkey FOREIGN KEY (id_habilidad) REFERENCES public.habilidad(id_habilidad);
 W   ALTER TABLE ONLY public.vol_habilidad DROP CONSTRAINT vol_habilidad_id_habilidad_fkey;
       public          postgres    false    3511    218    228            �           2606    18842 .   vol_habilidad vol_habilidad_id_voluntario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.vol_habilidad
    ADD CONSTRAINT vol_habilidad_id_voluntario_fkey FOREIGN KEY (id_voluntario) REFERENCES public.voluntario(id_voluntario);
 X   ALTER TABLE ONLY public.vol_habilidad DROP CONSTRAINT vol_habilidad_id_voluntario_fkey;
       public          postgres    false    3499    216    218            k      x�3�4�4�2�&`2F��� !��      i   Q   x�3�,HM)��,NU��I�MT�p�u��42�50�5����2&E�!�	T�cai�Bebr*T}�q��f^� -.S      g   A   x�3��".#N�b����Ԣ�|�����T�T��!�1A&U�TaFP�9AU��qqq �NG      e   *   x�3�,HM)��t,,�T�LLNU����pK㖊���� ���      c   B   x�3�,HM)ʇ�鹉�9z����ڦf��F�&�f�ɉ99�
i�9ŉ
@1.#2���'F��� Xj.�      a   (   x�3�4A.8��2����,8��24�3c���� �D      ]   G   x�3�L�QHNLJJ��WH�I�K�WHIU�K,��I��SH-V(����4B.#�Ts����mB��=... �..      _      x�3�4�4�2��`�L��qqq 4�v      [      x�3�4A�=... ^�      Y   V   x�3�,HM)��44�LN��IUHK�)NT042����M*J��;��&f��%��rj��Y�ML�̹�(�mL�n�t�R�ی"�1z\\\ يn�     