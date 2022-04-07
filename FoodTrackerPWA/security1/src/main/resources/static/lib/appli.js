let app = Vue.createApp({
    template: '<food-app " /> ',
})

app.component('food-app', {
    mounted: function () {
        this.loadData2();
        this.loadData();
    },
    computed: {
        filteredFoods: function () {
            return this.foods.filter((food) => {
                return food.generic_name.match(this.search);
            })
        }
    },
    data: () => ({
        foods: [],
        eaten: [],
        id_user: 0,
        email_user: "",
        search: "",
        total_cal: 0,
        consumed_cal:0,
        user: [],
    }),
    //    template: '<h1 :title=leTTRE> {{titre}}</h1> <p> Il ya {{ veges.length }} éléemnts</p>  <ul><li v-for="item in veges" :style="{background:item.color}" :title ="item.color" :key="item.name" >{{ item.name }} qui coute <span :title="[enCAD(item.price)]">{{ item.price }}</span></li> </ul> <button @click="ajoutTest()">Ajouttest</button>'

               
    template: `<h1> Bonjour {{user.firstName}} </h1>

    <input type="text" placeholder="Rechercher un aliment" v-model="search" id="searchfood" name="searchn" required
        size="10">

        <div style="overflow-y: scroll;
                background-color: #e9e9e9;
                
               font-size: 12px;
                height: 500px;text-align:justify;margin:5px;">
                                <table >
        <thead>
            <tr>
           
            <th>Generic Name</th>
            <th>Product Name</th>
            <th>Quantity in g</th>
            
            </tr>
        </thead>
        <tbody>
            <tr v-for="food in filteredFoods">
           
            <td>{{food.generic_name}}</td>
            <td>{{food.product_name}}</td>
            <td><input v-model="portion" type="number" ></td>
           
            <td><button  @click="add(portion,food._links.food.href)" > Add</button ></td>
            </tr>
        </tbody>
    </table>


        
        </div>
    
    
      <h3>Budget de calories par jour : {{total_cal}} Kcal </h3>
      <h3>Calories consommées : {{consumed_cal}} Kcal </h3>
      <h3>Calories restantes : {{total_cal-consumed_cal}} Kcal </h3>
      <h2> Aliments consommés </h2>
      <div style="font-size:12px;margin-bottom:500px">
      <table id="firstTable">
        <thead>
            <tr>
            <th>ID</th>
            <th>Generic Name</th>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Calories</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="eatens in eaten">
            <td>{{eatens.id}}</td>
            <td>{{eatens.food.generic_name}}</td>
            <td>{{eatens.food.product_name}}</td>
            <td>{{eatens.portion}}g</td>
            <td class="eaten" >{{((eatens.food.cal/100)*eatens.portion)}} kcal</td>
            <td><button  @click="DeleteEaten(eatens)" > Supprimer</button ></td>
            </tr>
        </tbody>
    </table>
    </div>
    <div><br> <br></div>
    
    `,
   
   
    

    methods: {
        add: async function (portion, id) {
            const d = new Date();
            year = d.getFullYear();
            day = d.getDate();
            if (day < 10) {
                day = '0' + day;
            }
            month = d.getMonth();
            date = year + '/' + month + '/' + day;
            id=id.replace("http://localhost:8080/api/foods/", "");
            console.log('Jajoute ' + portion + 'g');
            console.log(' du food id:' + id);
            console.log('Date du jour : ' + date);
            query = '/api/eatens/post?user=' + this.email_user + '&date=' + date + '&food=' + id + '&quantity=' + portion;
            let res = await fetch(query, {
                method: 'POST',
            })
            console.log(res);
            console.log(query);
            this.loadDataEaten();
            
       },
      


        DeleteEaten: async function (E) {
            this.eaten.splice(this.eaten.indexOf(E), 1);
            console.log('ceci est le id cliqué ' + E);
            query = '/api/eatens/' + E.id;
            let res = await fetch(query, {   
                credentials: 'include',
                method: 'DELETE'
            });
            let body = res;
            this.loadDataEaten();
            console.log(body);
        },
        loadData: async function () {
            let res = await fetch('/api/foods') 
            let body = await res.json()
            console.log(body);
           this.foods = body._embedded.foods
        },
        loadDataEaten: async function () {
            let res = await fetch('/api/eatens/get/'+this.id_user) 
            let body = await res.json()
            console.log(body);
            this.eaten = body;
            console.log(this.eaten[0].id);
            this.GetCal();
        },
        GetCal: async function () {
            this.consumed_cal = 0;
            for (var i = 0; i < this.eaten.length; i++)
            {
                portion = this.eaten[i].portion;
                cal = this.eaten[i].food.cal;
                this.consumed_cal=this.consumed_cal+((cal/100)*portion)
            }
        },
        loadData2: async function () {
            let res1 = await fetch('/api/currentuser');
            let email_user = await res1.text();
            var query = 'api/users/email/'+ email_user;
            let res2 = await fetch(query) // hard coded :(, not HATEOAS
            let body2 = await res2.json()
            this.id_user = body2.id;
            this.email_user = email_user;
            console.log('Id user : ' + this.id_user);
            console.log('email user : ' + email_user);
            this.loadDataEaten();
            this.loadUser();
        },
         loadUser: async function () {
             let res = await fetch('/api/users/' + this.id_user);
             let user = await res.json();
             this.user = user;
             if (user.gender == "Men") {
                 calories = (10 * user.weight) + (6.25 * user.height) - (5 * user.birthday) + 5;
             }
             else {
                 calories = (10 * user.weight) + (6.25 * user.height) - (5 * user.birthday) -161;
             }
             if (user.level_of_sport == 0) {
                 calories = calories * 1.1;
             }
             else {
                 calories = calories * 1.3;
             }
             console.log('CALORIEIEES : ' + calories);
            
            console.log('firstname : ' + user.firstName);
            console.log('lastname : ' + user.lastName);
             this.total_cal= calories;
        },

    }
})


let vm = app.mount('#container')
