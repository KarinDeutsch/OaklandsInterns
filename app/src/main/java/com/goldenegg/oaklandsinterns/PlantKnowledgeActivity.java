package com.goldenegg.oaklandsinterns;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.goldenegg.oaklandsinterns.adapters.PlantCategoryAdapter;
import com.goldenegg.oaklandsinterns.plant_knowledge.CategoryDetailActivity;
import com.goldenegg.oaklandsinterns.plant_knowledge.PlantCategory;

import java.util.ArrayList;
import java.util.List;

public class PlantKnowledgeActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCategories;
    private PlantCategoryAdapter adapter;
    private List<PlantCategory> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategories = findViewById(R.id.recyclerViewCategories);
        recyclerViewCategories.setHasFixedSize(true);
        recyclerViewCategories.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the category list with your data
        createCategoryList();

        adapter = new PlantCategoryAdapter(this, categoryList);
        recyclerViewCategories.setAdapter(adapter);

        adapter.setOnItemClickListener(new PlantCategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                PlantCategory clickedCategory = categoryList.get(position);

                // Create an Intent to start the CategoryDetailActivity
                Intent detailIntent = new Intent(PlantKnowledgeActivity.this, CategoryDetailActivity.class);
                // Pass the entire PlantCategory object using Parcelable
                detailIntent.putExtra(CategoryDetailActivity.EXTRA_CATEGORY, clickedCategory);
                startActivity(detailIntent);
            }
        });
    }

    private void createCategoryList() {
        categoryList = new ArrayList<>();

        // Ensure you have actual drawables in your res/drawable folder
        // Use meaningful descriptions and Ohio-specific context!

        // Trees
        categoryList.add(new PlantCategory(R.drawable.deciduous_trees_icon,
                "Deciduous Trees",
                "Trees shedding leaves annually; provides shade, fall colors.",
                "Deciduous trees are a hallmark of Ohio's landscape, unlike tropical evergreen forests. They mark the changing seasons, losing leaves in autumn and regrowing them in spring. Common types include Maples, Oaks, and Elms. Understanding their dormancy cycle is crucial for pruning and care.",
                "Require adequate water during dry periods. Prune during dormant season (late winter). Monitor for pests like Emerald Ash Borer. Fertilize young trees in spring.",
                "These trees define Ohio's beautiful autumns. Many provide valuable timber and urban shade. Recognizing species like Sugar Maple (Ohio's state tree) is essential."
        ));
        categoryList.add(new PlantCategory(R.drawable.evergreen_trees_icon,
                "Evergreen Trees",
                "Trees retaining needles/leaves year-round, for year-round green.",
                "Evergreen trees maintain their foliage throughout the year, offering winter interest and structure. They differ significantly from deciduous types in growth habit and needle/leaf structure. Examples include Pines, Spruces, and Firs.",
                "Prefer well-drained soil; avoid overwatering, especially in winter. Protect young trees from winter winds. Check for needle blight and bagworms.",
                "Used for privacy screens, windbreaks, and as focal points in Ohio gardens. Their consistent color provides contrast against winter snow. Adapt well to Ohio's colder temperatures."
        ));
        categoryList.add(new PlantCategory(R.drawable.native_trees_icon,
                "Native Ohio Trees",
                "Trees naturally found in Ohio, adapted to local climate and soil.",
                "Native trees are species that have naturally grown in Ohio's ecosystems for centuries. They are inherently adapted to the local climate, soil types, and often require less maintenance. Examples include the Ohio Buckeye, Pawpaw, Sycamore, and Tulip Poplar.",
                "Generally more resilient to local pests and diseases. Minimal pruning needed. Adapt well to average Ohio rainfall; may need supplemental watering during severe droughts.",
                "Crucial for Ohio's biodiversity and wildlife. They support local insect and bird populations. Understanding native varieties helps ensure successful plantings and ecological balance."
        ));

        // Shrubs
        categoryList.add(new PlantCategory(R.drawable.flowering_shrub_icon,
                "Flowering Shrubs",
                "Woody plants smaller than trees, known for their beautiful flowers, like Azaleas and Viburnums.",
                "These shrubs bloom with eye-catching flowers in spring or summer. In Ohio, they create color in gardens after the snow melts. Examples include Lilacs (fragrant), Forsythia (bright yellow), and Hydrangeas (long-lasting blooms).",
                "Place in sunny or lightly shaded spots. Water regularly in dry months. Prune after blooming to shape and encourage flowers next year.",
                "Popular for brightening Ohio yards and attracting bees and butterflies. Customers often choose them for seasonal color and curb appeal."
        ));

        categoryList.add(new PlantCategory(R.drawable.evergreen_shrubs_icon,
                "Evergreen Shrubs",
                "Shrubs that keep their foliage through winter, providing structure and winter interest.",
                "Unlike tropical evergreens, these survive Ohio’s winters with thick, hardy leaves. Boxwood, Holly, and Junipers are common types.",
                "Best in well-drained soil. Avoid heavy snow on branches—shake gently if needed. Prune lightly in spring to shape.",
                "Important for winter landscapes and privacy borders. Newcomers love that these stay green while trees lose leaves."
        ));

        categoryList.add(new PlantCategory(R.drawable.native_shrubs_icon,
                "Native Ohio Shrubs",
                "Shrubs indigenous to Ohio, resilient and beneficial for local wildlife. Includes Spice Bush and Elderberry.",
                "These shrubs naturally grow in Ohio forests and fields. They're easy to care for and support birds and pollinators.",
                "Minimal care required. Water if very dry. Use natural mulch to hold soil moisture.",
                "Great for ecological gardens. Elderberry has edible berries; Spice Bush smells sweet when crushed. Locals appreciate their connection to Ohio’s nature."
        ));

        // Perennials
        categoryList.add(new PlantCategory(R.drawable.sun_perennials_icon,
                "Sun-Loving Perennials",
                "Plants living over two years, thriving in full sun, attracting pollinators. Examples: Coneflowers, Daylilies.",
                "These grow back every year and love sunshine. They survive Ohio winters and bloom in warmer months.",
                "Plant in sunny spots. Water weekly in summer. Cut back in fall to help next season’s growth.",
                "Used to fill sunny beds with long-lasting color. Great for attracting bees and butterflies to gardens."
        ));

        categoryList.add(new PlantCategory(R.drawable.shade_perennials_icon,
                "Shade-Loving Perennials",
                "Perennials preferring partial or full shade, often with interesting foliage or delicate flowers. Hostas and Ferns are good examples.",
                "These thrive under trees or on the side of buildings where sunlight is weak. Their leaves are often big and bold.",
                "Keep soil moist. Use mulch to prevent drying. Hostas can be split every few years to make more plants.",
                "Perfect for shady corners of Ohio yards. Hostas are loved for their leaf shapes; ferns create a forest feel."
        ));

        categoryList.add(new PlantCategory(R.drawable.native_perennials_icon,
                "Native Ohio Perennials",
                "Herbaceous plants native to Ohio, important for local ecosystems. Includes Milkweed and Bee Balm.",
                "These plants return each year and are part of Ohio’s natural plant communities. They need little care and support wildlife like butterflies.",
                "Don’t over-water. Leave seed heads for birds in fall. Cut back dead stems in spring.",
                "Essential for pollinator gardens. Monarch butterflies lay eggs on Milkweed; Bee Balm smells fresh and attracts hummingbirds."
        ));

        // Annuals
        categoryList.add(new PlantCategory(R.drawable.annual_flowers_icon,
                "Annual Flowers",
                "Plants completing their cycle in one season, providing continuous color for bedding. Petunias and Marigolds are popular.",
                "These grow from seed, bloom all summer, and die when winter comes. Ideal for planting after last frost in spring.",
                "Water every few days in hot weather. Deadhead spent flowers to encourage new blooms.",
                "Used in containers and borders for instant color. Easy to sell and perfect for beginner gardeners."
        ));

        categoryList.add(new PlantCategory(R.drawable.edible_annuals_icon,
                "Edible Annuals (Vegetables & Herbs)",
                "Plants grown for harvest within a single year, like Tomatoes, Peppers, and various herbs.",
                "These grow quickly in Ohio summers and are harvested before frost. Includes leafy greens, root crops, and seasonings.",
                "Plant in good soil after danger of frost. Stake taller plants like tomatoes. Water deeply every few days.",
                "Popular with home gardeners and small urban farms. Customers love growing fresh food from nursery plants."
        ));

        // Grasses & Groundcovers
        categoryList.add(new PlantCategory(R.drawable.ornamental_grasses_icon,
                "Ornamental Grasses",
                "Grasses grown for their beauty, texture, and movement in the landscape.",
                "These grasses sway in the wind and add vertical interest to gardens. Examples include Fountain Grass and Switchgrass.",
                "Cut down to the ground in late winter before new growth begins. They don’t need frequent watering.",
                "Loved for low maintenance and year-round visual appeal. Excellent for beginner gardeners in Ohio."
        ));

        categoryList.add(new PlantCategory(R.drawable.groundcovers_icon,
                "Groundcovers",
                "Low-growing plants spreading to cover soil, suppressing weeds. Examples: Phlox, Vinca.",
                "Used instead of grass in difficult areas. These spread across the ground and stop weeds from growing.",
                "Plant close together. Water regularly first season. Trim edges to contain spread.",
                "Great for slopes, under trees, or shady spots where grass won’t grow. Common in Ohio landscapes to prevent erosion."
        ));

        categoryList.add(new PlantCategory(R.drawable.diseases_pests_icon,
                "Common Diseases & Pests",
                "Issues that harm plant health in Ohio, like fungal spots, powdery mildew, or pests like aphids and bagworms.",
                "Ohio's humidity and seasonal shifts lead to plant diseases like black spot (on roses), rust (on hollyhocks), and powdery mildew (on perennials). Common pests include Japanese beetles, aphids, and the Emerald Ash Borer.",
                "Watch for discolored leaves, holes, curling, or sticky residue. Remove damaged leaves, prune infected stems, and use organic sprays when possible. Don’t overcrowd plants—airflow matters!",
                "Nursery staff should learn to spot early signs and guide customers toward prevention (like proper spacing and watering). Use local extension services like OSU's Plant & Pest Diagnostic Center for accurate ID help."
        ));

        categoryList.add(new PlantCategory(R.drawable.chemical_treatment_icon,
                "Chemical Treatments & Safety",
                "Explains safe use of chemicals like fungicides or insecticides. Focuses on how to find the right product—not a full list.",
                "Some issues need chemical help—like fungicides for mildew or insecticides for bagworms. In Ohio, many garden centers carry safe, labeled options.",
                "Always read the label. Wear gloves. Don’t spray when it's windy. Follow dosage carefully. Organic options are available too, like neem oil.",
                "Help customers find products by asking about the plant and symptoms. If unsure, look up Ohio-specific recommendations online (like OSU Extension) or call experts. Avoid guessing—accuracy matters."
        ));

        categoryList.add(new PlantCategory(R.drawable.fertilizer_icon,
                "Fertilizer Basics",
                "How to help plants grow strong in Ohio using nutrients like nitrogen, phosphorus, and potassium.",
                "Fertilizer helps plants grow faster, bloom better, and resist stress. Ohio soil is often clay-rich, which can be low in key nutrients. Knowing what each fertilizer label means (NPK numbers) helps tailor care.",
                "Use slow-release fertilizer for most nursery plants. Add compost for natural nutrients. Apply in spring or early summer, not late fall—plants are preparing for dormancy then.",
                "Encourage customers to match fertilizer to plant needs. Leafy vegetables love nitrogen; flowering plants need phosphorus. Guide them to read the label or ask nursery staff for help."
        ));

    }
}